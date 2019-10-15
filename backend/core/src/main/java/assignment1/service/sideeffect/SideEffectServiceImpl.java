package assignment1.service.sideeffect;

import assignment1.dto.SideEffectDto;
import assignment1.dto.mapper.SideEffectMapper;
import assignment1.entities.SideEffect;
import assignment1.exception.ObjectNotFound;
import assignment1.repository.SideEffectRepository;
import assignment1.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SideEffectServiceImpl implements SideEffectService, CrudService<SideEffectDto> {

    private SideEffectRepository sideEffectRepository;

    public SideEffectServiceImpl(SideEffectRepository sideEffectRepository) {
        this.sideEffectRepository = sideEffectRepository;
    }

    @Override
    public List<SideEffectDto> getAll() {
        return this.sideEffectRepository.findAll().stream()
                .map(SideEffectMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public SideEffectDto getOne(Long id) throws ObjectNotFound {
        SideEffect sideEffect = this.sideEffectRepository.getOne(id);
        if (sideEffect == null) {
            throw new ObjectNotFound("Side effect not found");
        }
        return SideEffectMapper.convertToDto(sideEffect);
    }

    @Override
    public void delete(Long id) throws ObjectNotFound {
        SideEffect sideEffect = this.sideEffectRepository.getOne(id);
        if (sideEffect == null) {
            throw new ObjectNotFound("Side effect not found");
        }
        this.sideEffectRepository.delete(sideEffect);
    }

    @Override
    public SideEffectDto save(SideEffectDto obj) {
        SideEffect sideEffect = SideEffectMapper.convertToEntity(obj);

        return SideEffectMapper.convertToDto(this.sideEffectRepository.save(sideEffect));
    }
}
