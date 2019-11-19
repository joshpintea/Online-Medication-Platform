package assignment1.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name="activity")
public class Activity extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="patient_id")
    private Patient activityPatient;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="activity_lavel")
    private String activityLabel;

    public Activity() {
    }

    public Activity(Patient activityPatient, Date startDate, Date endDate, String activityLabel) {
        this.activityPatient = activityPatient;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activityLabel = activityLabel;
    }

    public Patient getActivityPatient() {
        return activityPatient;
    }

    public void setActivityPatient(Patient activityPatient) {
        this.activityPatient = activityPatient;
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

    @Override
    public String toString() {
        return "Activity{" +
                "activityPatient=" + activityPatient.getId() +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", activityLabel='" + activityLabel +
                '}';
    }
}
