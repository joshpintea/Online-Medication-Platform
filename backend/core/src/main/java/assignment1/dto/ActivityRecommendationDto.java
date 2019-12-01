package assignment1.dto;

public class ActivityRecommendationDto {
    private Long id;
    private String recommendation;

    private ActivityDto activityDto;

    public ActivityRecommendationDto() {
    }

    public ActivityRecommendationDto(Long id, String recommendation, ActivityDto activityDto) {
        this.id = id;
        this.recommendation = recommendation;
        this.activityDto = activityDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public ActivityDto getActivityDto() {
        return activityDto;
    }

    public void setActivityDto(ActivityDto activityDto) {
        this.activityDto = activityDto;
    }
}
