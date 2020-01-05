package assg4.web_service.entities;

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

    @Column(name="is_violated")
    private Boolean isViolated;

    @Column(name="is_normal")
    private Boolean isNormal;

    public Activity() {
    }

    public Activity(Patient activityPatient, Date startDate, Date endDate, String activityLabel) {
        this.activityPatient = activityPatient;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activityLabel = activityLabel;
    }

    public Activity(Patient activityPatient, Date startDate, Date endDate, String activityLabel, Boolean isViolated) {
        this.activityPatient = activityPatient;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activityLabel = activityLabel;
        this.isViolated = isViolated;
    }

    public Activity(Patient activityPatient, Date startDate, Date endDate, String activityLabel, Boolean isViolated, Boolean isNormal) {
        this.activityPatient = activityPatient;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activityLabel = activityLabel;
        this.isViolated = isViolated;
        this.isNormal = isNormal;
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

    public Boolean getIsViolated() {
        return isViolated;
    }

    public void setIsViolated(Boolean isViolated) {
        this.isViolated = isViolated;
    }

    public Boolean getViolated() {
        return isViolated;
    }

    public void setViolated(Boolean violated) {
        isViolated = violated;
    }

    public Boolean getNormal() {
        return isNormal;
    }

    public void setNormal(Boolean normal) {
        isNormal = normal;
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