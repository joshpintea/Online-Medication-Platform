package assignment1.dto.mapper;

import assignment1.dto.DrugDto;
import assignment1.entities.Drug;

import java.util.stream.Collectors;

public class DrugMapper {

    public static Drug convertToEntity(DrugDto drugDto) {
        Drug drug = new Drug();
        drug.setDosage(drugDto.getDosage());
        drug.setId(drugDto.getId());
        drug.setName(drugDto.getName());
        drug.setSideEffects(drugDto.getSideEffects()
                            .stream()
                            .map(SideEffectMapper::convertToEntity)
                            .collect(Collectors.toList()));

        return drug;
    }

    public static DrugDto convertToDto(Drug drug) {
        DrugDto drugDto = new DrugDto();
        drugDto.setId(drug.getId());
        drugDto.setDosage(drug.getDosage());
        drugDto.setName(drug.getName());
        drugDto.setSideEffects(drug.getSideEffects()
                                    .stream()
                                    .map(SideEffectMapper::convertToDto)
                                    .collect(Collectors.toList()));

        return drugDto;
    }
}
