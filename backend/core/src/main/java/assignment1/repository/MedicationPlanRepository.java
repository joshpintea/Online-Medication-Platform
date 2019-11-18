package assignment1.repository;

import assignment1.entities.MedicationPlan;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface MedicationPlanRepository extends BaseRepository<MedicationPlan> {
    List<MedicationPlan> getAllByPatientId(Long id);
    List<MedicationPlan> getAllByPatientIdAndStartDateGreaterThanAndEndDateLessThan(Long id, Date startDate, Date endDate);
}
