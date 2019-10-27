package assignment1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name="activity")
public class Activity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="activity_lavel")
    private String activityLabel;

    public Activity() {
    }

    public Activity(Patient patient, Date startDate, Date endDate, String activityLabel) {
        this.patient = patient;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activityLabel = activityLabel;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public String getActivityLabel() {
        return activityLabel;
    }

    public void setActivityLabel(String activityLabel) {
        this.activityLabel = activityLabel;
    }
}
