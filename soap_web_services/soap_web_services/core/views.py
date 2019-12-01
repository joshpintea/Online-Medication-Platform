from django.core.exceptions import ObjectDoesNotExist
from django.shortcuts import render

# Create your views here.
from django.views.decorators.csrf import csrf_exempt
from spyne import ResourceNotFoundError, Fault, DateTime

from spyne.server.django import DjangoApplication
from spyne.model.primitive import Unicode, Integer, Long, Date, Boolean
from spyne.model.complex import Iterable, ComplexModel, Array
from spyne.protocol.soap import Soap11
from spyne.application import Application
from spyne.decorator import rpc
from spyne.service import Service
from spyne.util.django import DjangoComplexModel

from soap_web_services.core.models import Activity, MedicationPlan, MedicationPlanInterval, ActivityRecommendation


class ActivityModel(DjangoComplexModel):
    class Attributes(DjangoComplexModel.Attributes):
        django_model = Activity


class MedicationPlanModel(DjangoComplexModel):
    class Attributes(DjangoComplexModel.Attributes):
        django_model = MedicationPlan


class MedicationPlanIntervalModel(DjangoComplexModel):
    class Attributes(DjangoComplexModel.Attributes):
        django_model = MedicationPlanInterval


class MedicationPlanNotObeyed(ComplexModel):
    medication_plan = MedicationPlanModel
    intake_intervals = Array(MedicationPlanIntervalModel)


class ActivityRecommendationModel(DjangoComplexModel):
    class Attributes(DjangoComplexModel.Attributes):
        django_model = ActivityRecommendation


class HelloWorldService(Service):
    @rpc(Unicode, Integer, _returns=Iterable(Unicode))
    def say_hello(self, name, times):
        print("Hlloe")
        for i in range(times):
            yield 'Hello, %s' % name


class ActivityService(Service):
    @rpc(Long, DateTime, _returns=Iterable(ActivityModel))
    def get_activities_by_patient_id(self, patient_id, datetime):
        date = datetime.date()
        activities_per_day = Activity.objects.filter(patient_id=patient_id, start_date__contains=date)

        for activity in activities_per_day:
            activity.is_normal = bool.from_bytes(activity.is_normal, "big")
            activity.is_violated = bool.from_bytes(activity.is_violated, "big")

        return activities_per_day

    @rpc(Long, Boolean, _returns=ActivityModel)
    def annotate_activity(self, activity_id, label):
        try:
            print(activity_id, label)
            activity = Activity.objects.get(pk=activity_id)

            if type(activity.is_violated) == bytes:
                activity.is_violated = bool.from_bytes(activity.is_violated, "big")

            activity.is_normal = label
            activity.save()
            return activity
        except Exception as ex:
            raise ResourceNotFoundError('Activity %s not found' % activity_id)

    @rpc(Long, Unicode)
    def add_recommendation(self, activity_id, recommendation):
        try:
            activity = Activity.objects.get(pk=activity_id)
            if type(activity.is_violated) == bytes:
                activity.is_violated = bool.from_bytes(activity.is_violated, "big")

            if type(activity.is_normal) == bytes:
                activity.is_normal = bool.from_bytes(activity.is_normal, "big")

            if activity.is_normal:
                raise Exception("Activity is labeled as normal")

            latest_activity = ActivityRecommendation.objects.latest('id')

            latest_id = latest_activity.id + 1

            activity_recommendation = ActivityRecommendation()
            activity_recommendation.id = latest_id
            activity_recommendation.activity_id = activity.id
            activity_recommendation.recommendation = recommendation
            activity_recommendation.save(force_insert=True)
        except ObjectDoesNotExist as ex:
            raise ResourceNotFoundError('Activity %s not found' % activity_id)
        except Exception as ex:
            raise Fault(faultstring=str(ex))


class MedicationPlanService(Service):
    @rpc(Long, DateTime, _returns=Iterable(MedicationPlanNotObeyed))
    def get_not_obeyed_medication_plan(self, patient_id, date_time):
        date = date_time.date()
        medication_plans = MedicationPlan.objects.filter(patient_id=patient_id,
                                                         start_date__lte=date,
                                                         end_date__gte=date)

        not_obeyed_medication_plans = []

        for medication_plan in medication_plans:
            intake_interval_period = medication_plan.intake_interval_period
            all_intake_interval = [(i * intake_interval_period, (i + 1) * intake_interval_period)
                                for i in range(0, 24 // medication_plan.intake_interval_period + 1, 2)]
            all_intake_interval = [(s, e) for s, e in all_intake_interval if s < 24 and e < 24]

            taken_medication_plan = MedicationPlanInterval.objects.filter(day=date,
                                                                          medication_plan=medication_plan.id,
                                                                          taken_on_time=True)
            if len(taken_medication_plan) == len(all_intake_interval):
                continue

            saved_intake_intervals = MedicationPlanInterval.objects.filter(day=date,
                                                                           medication_plan=medication_plan.id).order_by('intake_interval_start')

            for mdi in saved_intake_intervals:
                mdi.taken_on_time = int.from_bytes(mdi.taken_on_time, "big")

            intake_intervals = []

            intake_intervals = intake_intervals + saved_intake_intervals[::1]

            for s, e in all_intake_interval[len(saved_intake_intervals):]:
                mpi = MedicationPlanInterval()
                mpi.medication_plan = medication_plan
                mpi.day = date
                mpi.intake_interval_start = s
                mpi.intake_interval_end = e
                mpi.hour = s
                mpi.taken_on_time = False

                intake_intervals.append(mpi)

            med_plan = MedicationPlanNotObeyed()
            med_plan.medication_plan = medication_plan
            med_plan.intake_intervals = intake_intervals

            not_obeyed_medication_plans.append(med_plan)

        return not_obeyed_medication_plans


app = Application([ActivityService, MedicationPlanService],
                  'soap_web_services.core',
                  in_protocol=Soap11(validator='lxml'),
                  out_protocol=Soap11())

# hello_world_service = csrf_exempt(DjangoApplication(Application))
