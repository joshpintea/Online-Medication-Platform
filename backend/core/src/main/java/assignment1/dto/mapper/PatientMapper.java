package assignment1.dto.mapper;

import assignment1.dto.PatientDto;
import assignment1.entities.Patient;

public class PatientMapper {

    public static Patient convertToEntity(PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getUsername(),
                patientDto.getGender(),
                patientDto.getAddress(),
                patientDto.getName(),
                patientDto.getBirthDate(),
                CaregiverMapper.convertToEntity(patientDto.getCaregiverDto())
        );
    }

    public static PatientDto convertToDto(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getUsername(),
                patient.getGender(),
                patient.getAddress(),
                patient.getName(),
                patient.getBirthDate(),
                patient.getRole(),
                CaregiverMapper.convertToDto(patient.getCaregiver())
        );
    }
}
