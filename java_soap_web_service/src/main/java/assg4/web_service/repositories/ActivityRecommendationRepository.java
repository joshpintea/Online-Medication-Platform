package assg4.web_service.repositories;

import assg4.web_service.entities.ActivityRecommendation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRecommendationRepository extends BaseRepository<ActivityRecommendation> {
    List<ActivityRecommendation> getAllByActivity_ActivityPatient_Id(Long patientId);
}
