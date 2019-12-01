package assignment1.dto.mapper;

import assignment1.dto.ActivityRecommendationDto;
import core.recommendation_web_service.ActivityRecommendation;

public class ActivityRecommendationMapper {

    public static ActivityRecommendationDto convertToDto(ActivityRecommendation activityRecommendation) {
        return new ActivityRecommendationDto(
                activityRecommendation.getId(),
                activityRecommendation.getRecommendation(),
                ActivityMapper.convertToDto(activityRecommendation.getActivity())
        );
    }

}
