package assignment1.service.caregiver;

import assignment1.dto.ActivityRecommendationDto;
import assignment1.dto.mapper.ActivityRecommendationMapper;
import core.recommendation_web_service.ActivitiesPort;
import core.recommendation_web_service.ActivitiesPortService;
import core.recommendation_web_service.ActivityRecommendationRequest;
import core.recommendation_web_service.ActivityRecommendationResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;
import java.util.stream.Collectors;

public class CaregiverSoapService extends WebServiceGatewaySupport {

    public List<ActivityRecommendationDto> getActivityRecommendationForPatient(Long patientId) {
        ActivitiesPortService activitiesPortService = new ActivitiesPortService();
        ActivitiesPort app = activitiesPortService.getActivitiesPortSoap11();

        ActivityRecommendationRequest activityRecommendationRequest = new ActivityRecommendationRequest();
        activityRecommendationRequest.setPatientId(patientId);

        ActivityRecommendationResponse response = app.activityRecommendation(activityRecommendationRequest);

        return response.getActivityRecommendation()
                .stream()
                .map(ActivityRecommendationMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
