package assg4.web_service.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="activity_recommendation")
public class ActivityRecommendation extends BaseEntity {

    @ManyToOne
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
