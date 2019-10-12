package assignment1.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "caregiver")
public class Caregiver extends User {

    @OneToMany(mappedBy = "caregiver", fetch = FetchType.EAGER)
    private List<Patient> patients;

    public Caregiver() {
        this.role = UserRole.CAREGIVER;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
