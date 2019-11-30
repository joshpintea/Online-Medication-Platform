package assignment1.repository;

import assignment1.entities.MedicationPlanInterval;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface MedicationPlanIntervalRepository extends BaseRepository<MedicationPlanInterval> {
    List<MedicationPlanInterval> getAllByMedicationPlan_IdAndDate(Long medicationPlanId, Date date);
}
