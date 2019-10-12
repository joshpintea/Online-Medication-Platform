package assignment1.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "medication_plan")
public class MedicationPlan extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "medication_plan_to_drugs",
            joinColumns = {@JoinColumn(name = "medication_plan_id")},
            inverseJoinColumns = {@JoinColumn(name = "drug_id")}
    )
    private List<Drug> drugs = new ArrayList<>();

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

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
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
