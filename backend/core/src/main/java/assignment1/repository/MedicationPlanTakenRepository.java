package assignment1.repository;

import assignment1.entities.MedicationPlanTaken;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface MedicationPlanTakenRepository extends BaseRepository<MedicationPlanTaken> {
    List<MedicationPlanTaken> getAllByMedicationPlan_IdAndDate(Long medicationPlanId, Date date);
}
