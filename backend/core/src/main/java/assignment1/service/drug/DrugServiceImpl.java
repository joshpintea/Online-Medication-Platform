package assignment1.service.drug;

import assignment1.dto.DrugDto;
import assignment1.dto.mapper.DrugMapper;
import assignment1.entities.Drug;
import assignment1.exception.ObjectNotFound;
import assignment1.repository.DrugRepository;
import assignment1.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrugServiceImpl implements DrugService, CrudService<DrugDto> {
    private DrugRepository drugRepository;

    public DrugServiceImpl(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Override
    public List<DrugDto> getAll() {
        return this.drugRepository.findAll().stream()
                .map(DrugMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DrugDto getOne(Long id) throws ObjectNotFound {
        Drug drug = this.drugRepository.getOne(id);
        if (drug == null) {
            throw new ObjectNotFound("Drug not found");
        }
        return DrugMapper.convertToDto(drug);
    }

    @Override
    public void delete(Long id) throws ObjectNotFound {
        Drug drug = this.drugRepository.getOne(id);
        if (drug == null) {
            throw new ObjectNotFound("Drug not found");
        }

        this.drugRepository.delete(drug);
    }

    @Override
    public DrugDto save(DrugDto obj) {
        Drug drug = DrugMapper.convertToEntity(obj);
        Drug savedDrug = this.drugRepository.save(drug);
        return DrugMapper.convertToDto(savedDrug);
    }
}
