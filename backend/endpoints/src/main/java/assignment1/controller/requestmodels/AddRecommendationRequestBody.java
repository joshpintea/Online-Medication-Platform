package assignment1.controller.requestmodels;

public class AddRecommendationRequestBody {
    private Long activityId;
    private String message;

    public AddRecommendationRequestBody() {
    }

    public AddRecommendationRequestBody(Long activityId, String message) {
        this.activityId = activityId;
        this.message = message;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
