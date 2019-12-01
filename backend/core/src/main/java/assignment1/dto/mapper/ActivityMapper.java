package assignment1.dto.mapper;

import assignment1.dto.ActivityDto;
import assignment1.dto.ActivityViewDto;
import assignment1.entities.Activity;
import views.core.soap_web_services.ActivityModel;

public class ActivityMapper {

    public static ActivityViewDto convertToDto(Activity activity) {
        return new ActivityViewDto(activity.getId(),
                UserMapper.convertToDto(activity.getActivityPatient()),
                activity.getStartDate(),
                activity.getEndDate(),
                activity.getActivityLabel(),
                activity.getIsViolated());
    }

    public static ActivityDto convertToDto(ActivityModel activityModel) {
        return new ActivityDto(
                activityModel.getId(),
                activityModel.getPatientId().getValue(),
                activityModel.getActivityLavel().getValue(),
                activityModel.getStartDate().getValue().toGregorianCalendar().getTime(),
                activityModel.getEndDate().getValue().toGregorianCalendar().getTime(),
                activityModel.getIsViolated().getValue(),
                activityModel.getIsNormal().getValue()
        );
    }

    public static ActivityDto convertToDto(core.recommendation_web_service.Activity activity) {
        return new ActivityDto(
                activity.getId(),
                null,
                activity.getActivityLabel(),
                activity.getStartDate().toGregorianCalendar().getTime(),
                activity.getEndDate().toGregorianCalendar().getTime(),
                activity.isIsViolated(),
                activity.isIsNormal()
        );
    }
}
