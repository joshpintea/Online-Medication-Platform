package assignment1.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity(name = "patient")
public class Patient extends User {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "caregiver_id", nullable = false)
    private Caregiver caregiver;


    public Patient() {
        super();
        this.role = UserRole.ROLE_PATIENT;
    }

    public Patient(Long id, String username, String gender, String address, String name, Date birthDate) {
        super(id, username, gender, address, name, birthDate);
        this.role = UserRole.ROLE_PATIENT;
    }

    public Patient(Long id, String username, String gender, String address, String name, Date birthDate, Caregiver caregiver) {
        super(id, username, gender, address, name, birthDate);
        this.role = UserRole.ROLE_PATIENT;
        this.caregiver = caregiver;
    }


    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }
}
