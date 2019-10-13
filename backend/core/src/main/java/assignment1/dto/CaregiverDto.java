package assignment1.dto;

import assignment1.entities.UserRole;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CaregiverDto extends UserDto {
    private List<PatientDto> patients = new ArrayList<>();

    public CaregiverDto() {
    }

    public CaregiverDto(Long id, String username, String gender, String address, String name, Date birthDate,
                        UserRole userRole, List<PatientDto> patients) {
        super(id, username, gender, address, name, birthDate, userRole);
        this.patients = patients;
    }

    public List<PatientDto> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientDto> patients) {
        this.patients = patients;
    }
}
