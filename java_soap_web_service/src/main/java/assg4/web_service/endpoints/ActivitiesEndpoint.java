package assg4.web_service.endpoints;

import assg4.web_service.entities.ActivityRecommendation;
import assg4.web_service.mapper.ActivityRecommendationMapper;
import assg4.web_service.service.activity.ActivityService;
import core.recommendation_web_service.ActivityRecommendationRequest;
import core.recommendation_web_service.ActivityRecommendationResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;


@Endpoint
public class ActivitiesEndpoint {
    private static final String NAMESPACE_URI = "core/recommendation-web-service";


    private ActivityService activityService;

    public ActivitiesEndpoint(ActivityService activityService) {
        this.activityService = activityService;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ActivityRecommendationRequest")
    @ResponsePayload
    public ActivityRecommendationResponse getActivitites(@RequestPayload ActivityRecommendationRequest request) {
        ActivityRecommendationResponse response = new ActivityRecommendationResponse();
        List<ActivityRecommendation> l = this.activityService.getActivityRecommendationByPatient(request.getPatientId());

        for (ActivityRecommendation ar: l) {
            response.getActivityRecommendation().add(ActivityRecommendationMapper.convertToXmlObj(ar));
        }

        return response;
    }
}
