package assignment1.service.patient;

import assignment1.dto.MedicationPlanDto;
import assignment1.dto.PatientDto;
import assignment1.dto.mapper.MedicationPlanMapper;
import assignment1.dto.mapper.PatientMapper;
import assignment1.entities.Patient;
import assignment1.exception.ObjectNotFound;
import assignment1.repository.PatientRepository;
import assignment1.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService, CrudService<PatientDto> {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientDto> getAll() {
        return this.patientRepository.findAll().stream()
                .map(PatientMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto getOne(Long id) throws ObjectNotFound {
        Patient patient = this.patientRepository.getOne(id);
        if (patient == null) {
            throw new ObjectNotFound("Patient not found");
        }
        return PatientMapper.convertToDto(patient);
    }

    @Override
    public void delete(Long id) throws ObjectNotFound {
        Patient patient = this.patientRepository.getOne(id);
        if (patient == null) {
            throw new ObjectNotFound("Patient not found");
        }

        this.patientRepository.delete(patient);
    }

    @Override
    public PatientDto save(PatientDto obj) {
        Patient patient = PatientMapper.convertToEntity(obj);

        return PatientMapper.convertToDto(this.patientRepository.save(patient));
    }

    @Override
    public List<MedicationPlanDto> getMedicationsPlanByPatient(Long id) throws ObjectNotFound {
        Patient patient = this.patientRepository.getOne(id);
        if (patient == null) {
            throw new ObjectNotFound("Patient not found");
        }

        return patient.getMedicationPlans().stream()
                .map(MedicationPlanMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
