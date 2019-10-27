package assignment1.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "side_effect")
public class SideEffect extends BaseEntity {
    private String description;

    @ManyToMany(mappedBy="sideEffects")
    private Set<Drug> drugs = new HashSet<>();

    public SideEffect() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(Set<Drug> drugs) {
        this.drugs = drugs;
    }

    @Override
    public String toString() {
        return "SideEffect{" +
                "description='" + description  +
                '}';
    }
}
