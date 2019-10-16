package assignment1.service.caregiver;

import assignment1.dto.PatientDto;
import assignment1.exception.ObjectNotFound;

import java.util.List;

public interface CaregiverService {
    List<PatientDto> getPatientsOfCaregiver(Long id) throws ObjectNotFound;
}
