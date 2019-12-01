package assg4.web_service.service.activity;


import assg4.web_service.entities.ActivityRecommendation;

import java.util.List;

public interface ActivityService {
    List<ActivityRecommendation> getActivityRecommendationByPatient(Long patientId);
}
