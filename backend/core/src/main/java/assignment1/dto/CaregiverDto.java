package assignment1.dto;

import java.io.Serializable;
import java.sql.Date;

public class CaregiverDto extends UserDto implements Serializable {

    public CaregiverDto() {
    }

    public CaregiverDto(Long id, String username, String gender, String address, String name, Date birthDate,
                        UserRoleDto userRole) {
        super(id, username, gender, address, name, birthDate, userRole);
    }

}
