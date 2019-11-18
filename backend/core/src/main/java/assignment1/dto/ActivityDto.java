package assignment1.dto;

import java.io.Serializable;
import java.util.Date;

public class ActivityDto implements Serializable {
    private Long patientId;
    private String activityLabel;
    private Date start;
    private Date end;

    public ActivityDto() {

    }

    public ActivityDto(Long patientId, String activityLabel, Date start, Date end) {
        this.patientId = patientId;
        this.activityLabel = activityLabel;
        this.start = start;
        this.end = end;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getActivityLabel() {
        return activityLabel;
    }

    public void setActivityLabel(String activityLabel) {
        this.activityLabel = activityLabel;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "ActivityDto{" +
                "patientId=" + patientId +
                ", activityLabel='" + activityLabel + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
