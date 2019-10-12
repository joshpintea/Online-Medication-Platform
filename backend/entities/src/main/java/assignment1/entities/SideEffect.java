package assignment1.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "side_effect")
public class SideEffect extends BaseEntity {
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "drug_to_side_effects",
            joinColumns = {@JoinColumn(name = "side_effect_id")},
            inverseJoinColumns = {@JoinColumn(name = "drug_id")}
    )
    private List<Drug> drugs = new ArrayList<>();

    public SideEffect() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
}
