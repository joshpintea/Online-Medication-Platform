package assignment1.dto;


import java.io.Serializable;
import java.util.Date;

public class ActivityViewDto implements Serializable {
    private Long id;
    private UserDto patient;
    private Date startDate;
    private Date endDate;
    private String activityLabel;
    private Boolean isViolated;

    public ActivityViewDto() {
    }

    public ActivityViewDto(Long id, UserDto patient, Date startDate, Date endDate, String activityLabel, Boolean isViolated) {
        this.id = id;
        this.patient = patient;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activityLabel = activityLabel;
        this.isViolated = isViolated;

    }

    public UserDto getPatient() {
        return patient;
    }

    public void setPatient(UserDto patient) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getViolated() {
        return isViolated;
    }

    public void setViolated(Boolean violated) {
        isViolated = violated;
    }
}
