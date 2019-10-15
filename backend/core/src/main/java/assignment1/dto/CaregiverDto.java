package assignment1.dto;

import assignment1.entities.UserRole;

import java.sql.Date;

public class CaregiverDto extends UserDto {

    public CaregiverDto() {
    }

    public CaregiverDto(Long id, String username, String gender, String address, String name, Date birthDate,
                        UserRole userRole) {
        super(id, username, gender, address, name, birthDate, userRole);
    }

}
