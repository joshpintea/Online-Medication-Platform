package assg4.web_service.repositories;

import assg4.web_service.entities.MedicationPlan;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface MedicationPlanRepository extends BaseRepository<MedicationPlan> {
    List<MedicationPlan> getAllByPatientId(Long id);
    List<MedicationPlan> getAllByPatientIdAndStartDateLessThanAndEndDateGreaterThan(Long id, Date startDate, Date endDate);
}
