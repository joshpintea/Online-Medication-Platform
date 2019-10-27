package assignment1.dto.mapper;

import assignment1.dto.ActivityViewDto;
import assignment1.entities.Activity;

public class ActivityMapper {

    public static ActivityViewDto convertToDto(Activity activity) {
        return new ActivityViewDto(activity.getId(),
                UserMapper.convertToDto(activity.getPatient()),
                activity.getStartDate(),
                activity.getEndDate(),
                activity.getActivityLabel());
    }
}
