package assignment1.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name="activity_recommendation")
public class ActivityRecommendation extends BaseEntity {

    @OneToOne
    private Activity activity;

    private String recommendation;

    public ActivityRecommendation() {
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
