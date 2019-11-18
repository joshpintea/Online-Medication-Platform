package assignment1.dto.mapper;

import assignment1.dto.CaregiverDto;
import assignment1.entities.Caregiver;

public class CaregiverMapper {

    public static Caregiver convertToEntity(CaregiverDto caregiverDto) {
        return new Caregiver(
            caregiverDto.getId(),
            caregiverDto.getUsername(),
            caregiverDto.getGender(),
            caregiverDto.getAddress(),
            caregiverDto.getName(),
            caregiverDto.getBirthDate()
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
                UserRoleMapper.convertToDto(caregiver.getRole())
        );
    }
}
