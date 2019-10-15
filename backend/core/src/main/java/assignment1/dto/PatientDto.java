package assignment1.dto;

import assignment1.entities.UserRole;

import java.sql.Date;

public class PatientDto extends UserDto {
    private CaregiverDto caregiverDto;

    public PatientDto() {
    }

    public PatientDto(Long id, String username, String gender, String address, String name, Date birthDate, UserRole userRole, CaregiverDto caregiverDto) {
        super(id, username, gender, address, name, birthDate, userRole);
        this.caregiverDto = caregiverDto;
    }

    public CaregiverDto getCaregiverDto() {
        return caregiverDto;
    }

    public void setCaregiverDto(CaregiverDto caregiverDto) {
        this.caregiverDto = caregiverDto;
    }
}
