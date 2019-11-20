package assignment1.service.pildispenser;

import assignment1.dto.IntakeInterval;
import assignment1.dto.MedicationPlanDto;
import assignment1.dto.MedicationPlanInterval;
import assignment1.exception.InvalidInterval;
import assignment1.exception.PatientNotFound;

import java.util.List;

public interface PillDispenserService {
    List<MedicationPlanInterval> getNotTakenMedicationPlans(Long idPatient) throws PatientNotFound;
    MedicationPlanDto takeMedication(MedicationPlanDto medicationPlanDto, IntakeInterval intakeInterval) throws InvalidInterval;
    void patientDidNotTakeMedication(MedicationPlanDto medicationPlanDto);

}
