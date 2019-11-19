package assignment1.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "medication_plan")
public class MedicationPlan extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "medication_plan_to_drugs",
            joinColumns = {@JoinColumn(name = "medication_plan_id")},
            inverseJoinColumns = {@JoinColumn(name = "drug_id")}
    )
    private Set<Drug> drugs = new HashSet<>();

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "intake_interval")
    private Integer intakeInterval;

    public MedicationPlan() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(Set<Drug> drugs) {
        this.drugs = drugs;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getIntakeInterval() {
        return intakeInterval;
    }

    public void setIntakeInterval(Integer intakeInterval) {
        this.intakeInterval = intakeInterval;
    }
}
