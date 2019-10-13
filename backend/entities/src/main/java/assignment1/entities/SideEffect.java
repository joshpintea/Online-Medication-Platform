package assignment1.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "side_effect")
public class SideEffect extends BaseEntity {
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "drug_to_side_effects",
            joinColumns = {@JoinColumn(name = "side_effect_id")},
            inverseJoinColumns = {@JoinColumn(name = "drug_id")}
    )
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
}
