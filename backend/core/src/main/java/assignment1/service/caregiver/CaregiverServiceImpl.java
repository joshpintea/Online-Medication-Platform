package assignment1.service.caregiver;

import assignment1.dto.CaregiverDto;
import assignment1.dto.mapper.CaregiverMapper;
import assignment1.entities.Caregiver;
import assignment1.exception.ObjectNotFound;
import assignment1.repository.CaregiverRepository;
import assignment1.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaregiverServiceImpl implements CaregiverService, CrudService<CaregiverDto> {

    private CaregiverRepository caregiverRepository;

    public CaregiverServiceImpl(CaregiverRepository caregiverRepository) {
        this.caregiverRepository = caregiverRepository;
    }

    @Override
    public List<CaregiverDto> getAll() {
        return this.caregiverRepository.findAll()
                .stream()
                .map(CaregiverMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CaregiverDto getOne(Long id) throws ObjectNotFound {
        Caregiver caregiver = this.caregiverRepository.getOne(id);
        if (caregiver == null) {
            throw new ObjectNotFound("Caregiver not found");
        }

        return CaregiverMapper.convertToDto(caregiver);
    }

    @Override
    public void delete(Long id) throws ObjectNotFound {
        Caregiver caregiver = this.caregiverRepository.getOne(id);
        if (caregiver == null) {
            throw new ObjectNotFound("Caregiver not found");
        }

        this.caregiverRepository.delete(caregiver);
    }

    @Override
    public CaregiverDto save(CaregiverDto obj) {
        Caregiver caregiver = CaregiverMapper.convertToEntity(obj);

        return CaregiverMapper.convertToDto(this.caregiverRepository.save(caregiver));
    }
}
