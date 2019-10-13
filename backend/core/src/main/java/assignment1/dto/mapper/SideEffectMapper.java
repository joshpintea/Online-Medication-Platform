package assignment1.dto.mapper;

import assignment1.dto.SideEffectDto;
import assignment1.entities.SideEffect;

public class SideEffectMapper {

    public static SideEffect convertToEntity(SideEffectDto sideEffectDto) {
        SideEffect sideEffect = new SideEffect();
        sideEffect.setId(sideEffectDto.getId());
        sideEffect.setDescription(sideEffectDto.getDescription());

        return sideEffect;
    }

    public static SideEffectDto convertToDto(SideEffect sideEffect) {
        SideEffectDto sideEffectDto = new SideEffectDto();
        sideEffectDto.setId(sideEffect.getId());
        sideEffectDto.setDescription(sideEffect.getDescription());

        return sideEffectDto;
    }
}
