package assignment1.controller.requestmodels;

public class AnnotateActivityRequestBody {
    private Long activityId;
    private boolean label;

    public AnnotateActivityRequestBody() {

    }

    public AnnotateActivityRequestBody(Long activityId, boolean label) {
        this.activityId = activityId;
        this.label = label;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public boolean isLabel() {
        return label;
    }

    public void setLabel(boolean label) {
        this.label = label;
    }
}
