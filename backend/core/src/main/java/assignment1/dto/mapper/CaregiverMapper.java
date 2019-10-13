package assignment1.dto.mapper;

import assignment1.dto.CaregiverDto;
import assignment1.entities.Caregiver;

import java.util.stream.Collectors;

public class CaregiverMapper {

    public static Caregiver convertToEntity(CaregiverDto caregiverDto) {
        return new Caregiver(
            caregiverDto.getId(),
            caregiverDto.getUsername(),
            caregiverDto.getGender(),
            caregiverDto.getAddress(),
            caregiverDto.getName(),
            caregiverDto.getBirthDate(),
            caregiverDto.getPatients().stream()
                        .map(PatientMapper::convertToEntity)
                        .collect(Collectors.toList())
        );
    }

    public static CaregiverDto convertToDto(Caregiver caregiver) {
        return new CaregiverDto(
                caregiver.getId(),
                caregiver.getUsername(),
                caregiver.getGender(),
                caregiver.getAddress(),
                caregiver.getName(),
                caregiver.getBirthDate(),
                caregiver.getRole(),
                caregiver.getPatients().stream()
                            .map(PatientMapper::convertToDto)
                            .collect(Collectors.toList())
        );
    }
}
