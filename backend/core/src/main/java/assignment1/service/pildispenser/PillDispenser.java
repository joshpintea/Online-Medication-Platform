package assignment1.service.pildispenser;

import assignment1.dto.MedicationPlanDto;
import assignment1.exception.IncorrectInterval;

import java.util.List;

public interface PillDispenser {
    List<MedicationPlanDto> getNotTakenMedicationPlans(Long idPatient);
    MedicationPlanDto takeMedication(MedicationPlanDto medicationPlanDto) throws IncorrectInterval;
    void patientDidNotTakeMedication(MedicationPlanDto medicationPlanDto);

}
