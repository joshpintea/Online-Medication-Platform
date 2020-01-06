package assg4.web_service.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="drug")
public class Drug extends BaseEntity {
    private String name;
    private Long dosage;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "drug_to_side_effects",
            joinColumns = {@JoinColumn(name = "drug_id")},
            inverseJoinColumns = {@JoinColumn(name = "side_effect_id")}
    )
    private Set<SideEffect> sideEffects = new HashSet<>();

    public Drug() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDosage() {
        return dosage;
    }

    public void setDosage(Long dosage) {
        this.dosage = dosage;
    }

    public Set<SideEffect> getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(Set<SideEffect> sideEffects) {
        this.sideEffects = sideEffects;
    }


    @Override
    public String toString() {
        return "Drug{" +
                "name='" + name + '\'' +
                ", dosage=" + dosage +
                ", sideEffects=" + sideEffects +
                '}';
    }
}
