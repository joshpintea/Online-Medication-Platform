package assignment1.service.pildispenser;

import assignment1.dto.MedicationPlanDto;
import assignment1.exception.InvalidInterval;
import javafx.util.Pair;

import java.util.List;

public interface PillDispenser {
    List<MedicationPlanDto> getNotTakenMedicationPlans(Long idPatient);
    MedicationPlanDto takeMedication(MedicationPlanDto medicationPlanDto, Pair<Integer, Integer> medicationPlanInterval) throws InvalidInterval;
    void patientDidNotTakeMedication(MedicationPlanDto medicationPlanDto);

}
