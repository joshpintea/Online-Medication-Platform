package assg4.web_service.service.activity;

import assg4.web_service.entities.ActivityRecommendation;
import assg4.web_service.repositories.ActivityRecommendationRepository;
import assg4.web_service.repositories.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    private ActivityRepository activityRepository;
    private ActivityRecommendationRepository activityRecommendationRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository, ActivityRecommendationRepository activityRecommendationRepository) {
        this.activityRepository = activityRepository;
        this.activityRecommendationRepository = activityRecommendationRepository;
    }

    @Override
    public List<ActivityRecommendation> getActivityRecommendationByPatient(Long patientId) {
        return this.activityRecommendationRepository.getAllByActivity_ActivityPatient_Id(patientId);
    }
}
