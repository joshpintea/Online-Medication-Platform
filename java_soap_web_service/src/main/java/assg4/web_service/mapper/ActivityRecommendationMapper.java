package assg4.web_service.mapper;

import core.recommendation_web_service.ActivityRecommendation;

public class ActivityRecommendationMapper {

    public static ActivityRecommendation convertToXmlObj(assg4.web_service.entities.ActivityRecommendation ar) {
        ActivityRecommendation activityRecommendation = new ActivityRecommendation();
        activityRecommendation.setId(ar.getId());
        activityRecommendation.setRecommendation(ar.getRecommendation());
        activityRecommendation.setActivity(ActivityMapper.convertToXmlObject(ar.getActivity()));

        return activityRecommendation;
    }
}
