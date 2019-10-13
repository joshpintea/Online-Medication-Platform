package assignment1.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

@Entity(name = "caregiver")
public class Caregiver extends User {

    @OneToMany(mappedBy = "caregiver", fetch = FetchType.EAGER)
    private List<Patient> patients;

    public Caregiver() {
        this.role = UserRole.ROLE_CAREGIVER;
    }

    public Caregiver(Long id, String username, String gender, String address, String name, Date birthDate) {
        super(id, username, gender, address, name, birthDate);
        this.role = UserRole.ROLE_CAREGIVER;
    }

    public Caregiver(Long id, String username, String gender, String address, String name, Date birthDate, List<Patient> patients) {
        super(id, username, gender, address, name, birthDate);
        this.patients = patients;
        this.role = UserRole.ROLE_CAREGIVER;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
