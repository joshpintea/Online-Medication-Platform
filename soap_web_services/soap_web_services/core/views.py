from django.shortcuts import render

# Create your views here.
from django.views.decorators.csrf import csrf_exempt

from spyne.server.django import DjangoApplication
from spyne.model.primitive import Unicode, Integer, Long, Date
from spyne.model.complex import Iterable
from spyne.protocol.soap import Soap11
from spyne.application import Application
from spyne.decorator import rpc
from spyne.service import Service
from spyne.util.django import DjangoComplexModel

from soap_web_services.core.models import Activity


class ActivityModel(DjangoComplexModel):
    class Attributes(DjangoComplexModel.Attributes):
        django_model = Activity


class HelloWorldService(Service):
    @rpc(Unicode, Integer, _returns=Iterable(Unicode))
    def say_hello(self, name, times):
        print("Hlloe")
        for i in range(times):
            yield 'Hello, %s' % name


class ActivityService(Service):
    @rpc(Long, Date, _returns=Iterable(ActivityModel))
    def get_activities_by_patient_id(self, patient_id, date):
        activities = Activity.objects.filter(patient_id=patient_id)
        return activities


app = Application([HelloWorldService, ActivityService],
                  'soap_web_services.core',
                  in_protocol=Soap11(validator='lxml'),
                  out_protocol=Soap11())


# hello_world_service = csrf_exempt(DjangoApplication(Application))
