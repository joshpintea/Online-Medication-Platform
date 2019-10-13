package assignment1.dto;

import java.util.ArrayList;
import java.util.List;

public class DrugDto {
    private Long id;
    private String name;
    private Long dosage;
    private List<SideEffectDto> sideEffects = new ArrayList<>();

    public DrugDto() {
    }

    public List<SideEffectDto> getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(List<SideEffectDto> sideEffects) {
        this.sideEffects = sideEffects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
