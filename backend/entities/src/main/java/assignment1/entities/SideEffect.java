package assignment1.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "side_effect")
public class SideEffect extends BaseEntity {
    private String description;

    @ManyToMany(mappedBy="sideEffects")
    private List<Drug> drugs = new ArrayList<>();

    public SideEffect() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    @Override
    public String toString() {
        return "SideEffect{" +
                "description='" + description  +
                '}';
    }
}
