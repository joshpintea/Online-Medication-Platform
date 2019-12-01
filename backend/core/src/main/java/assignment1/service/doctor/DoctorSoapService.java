package assignment1.service.doctor;

import assignment1.dto.ActivityDto;
import assignment1.dto.MedPlanNotObeyed;
import assignment1.dto.mapper.ActivityMapper;
import assignment1.dto.mapper.MedicationPlanMapper;
import assignment1.util.DateUtil;
import core.soap_web_services.ActivityService;
import core.soap_web_services.Application;
import core.soap_web_services.MedicationPlanService;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import views.core.soap_web_services.ActivityModel;
import views.core.soap_web_services.ActivityModelArray;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorSoapService extends WebServiceGatewaySupport {

    public List<ActivityDto> getActivitiesByPatientId(Long patientId, Date date) {
        ActivityService activityService = new ActivityService();
        Application application = activityService.getApplication();
        ActivityModelArray activityArray = application.getActivitiesByPatientId(patientId, DateUtil.convertDateToXmlGregorianCalendar(date));

        return activityArray.getActivityModel().stream().map(ActivityMapper::convertToDto).collect(Collectors.toList());
    }

    public ActivityDto annotateActivity(Long activityId, Boolean label) {
        System.out.println(activityId + " " + label);
        ActivityService activityService = new ActivityService();
        Application application = activityService.getApplication();

        ActivityModel activityModel = application.annotateActivity(activityId, label);

        return ActivityMapper.convertToDto(activityModel);
    }

    public void addRecommendation(Long activityId, String recommendation) {
        ActivityService activityService = new ActivityService();
        Application application = activityService.getApplication();

        application.addRecommendation(activityId, recommendation);
    }

    public List<MedPlanNotObeyed> getNotObeyedMedPlan(Long patientId, Date date) {
        MedicationPlanService medicationPlanService = new MedicationPlanService();
        Application application = medicationPlanService.getApplication();

        return application.getNotObeyedMedicationPlan(patientId,
                DateUtil.convertDateToXmlGregorianCalendar(date))
                .getMedicationPlanNotObeyed()
                .stream()
                .map(MedicationPlanMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
