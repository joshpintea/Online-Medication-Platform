package assignment1.dto;

import assignment1.entities.UserRole;

import java.sql.Date;

public class PatientDto extends UserDto {

    public PatientDto() {
    }

    public PatientDto(Long id, String username, String gender, String address, String name, Date birthDate, UserRole userRole) {
        super(id, username, gender, address, name, birthDate, userRole);
    }
}
