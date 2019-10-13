package assignment1.service.patient;

import assignment1.dto.MedicationPlanDto;
import assignment1.exception.ObjectNotFound;

import java.util.List;

public interface PatientService {
    List<MedicationPlanDto> getMedicationsPlanByPatient(Long id) throws ObjectNotFound;
}
