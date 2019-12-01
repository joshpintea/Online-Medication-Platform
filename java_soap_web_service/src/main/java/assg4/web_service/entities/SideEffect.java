package assg4.web_service.entities;

import javax.persistence.Entity;

@Entity(name = "side_effect")
public class SideEffect extends BaseEntity {
    private String description;

    public SideEffect() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "SideEffect{" +
                "description='" + description  +
                '}';
    }
}
