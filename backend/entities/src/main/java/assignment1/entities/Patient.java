package assignment1.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "patient")
public class Patient extends User {

    @ManyToOne
    @JoinColumn(name = "caregiver_id")
    private Caregiver caregiver;

    @OneToMany(mappedBy = "patient")
    private List<MedicationPlan> medicationPlans = new ArrayList<>();

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<Activity> activities = new ArrayList<>();


    public Patient() {
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

    public Patient(Long id, String username, String gender, String address, String name, Date birthDate,
                   Caregiver caregiver, List<MedicationPlan> medicationPlans) {
        super(id, username, gender, address, name, birthDate);
        this.caregiver = caregiver;
        this.medicationPlans = medicationPlans;
        this.role = UserRole.ROLE_PATIENT;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public List<MedicationPlan> getMedicationPlans() {
        return medicationPlans;
    }

    public void setMedicationPlans(List<MedicationPlan> medicationPlans) {
        this.medicationPlans = medicationPlans;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
