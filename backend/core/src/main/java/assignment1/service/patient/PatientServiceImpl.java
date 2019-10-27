package assignment1.service.patient;

import assignment1.dto.MedicationPlanDto;
import assignment1.dto.PatientDto;
import assignment1.dto.mapper.MedicationPlanMapper;
import assignment1.dto.mapper.PatientMapper;
import assignment1.entities.Patient;
import assignment1.entities.User;
import assignment1.exception.ObjectNotFound;
import assignment1.exception.UsernameIsTaken;
import assignment1.repository.MedicationPlanRepository;
import assignment1.repository.PatientRepository;
import assignment1.service.CrudService;
import assignment1.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService, CrudService<PatientDto> {

    private PatientRepository patientRepository;
    private MedicationPlanRepository medicationPlanRepository;
    private UserService userService;

    public PatientServiceImpl(PatientRepository patientRepository, MedicationPlanRepository medicationPlanRepository, UserService userService) {
        this.patientRepository = patientRepository;
        this.userService = userService;
        this.medicationPlanRepository = medicationPlanRepository;
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

        if (patient.getId() == null) {
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
    public PatientDto save(PatientDto obj) throws UsernameIsTaken {
        Patient patient = PatientMapper.convertToEntity(obj);
        // check if patient exist.
        if (patient.getId() != null) {
            Patient patient1 = this.patientRepository.getOne(patient.getId());

            // update fields that are not into the dto
            if (patient1 != null) {
                patient.setPassword(patient1.getPassword());
            }
        } else {
            User user = this.userService.getUserAfterUsername(patient.getUsername());
            if (user != null) {
                throw new UsernameIsTaken();
            }

            patient.setPassword("default");
        }
        return PatientMapper.convertToDto(this.patientRepository.save(patient));
    }

    @Override
    public List<MedicationPlanDto> getMedicationsPlanByPatient(Long id) throws ObjectNotFound {
        Patient patient = this.patientRepository.getOne(id);
        if (patient == null) {
            throw new ObjectNotFound("Patient not found");
        }

        return this.medicationPlanRepository.getAllByPatientId(id).stream()
                .map(MedicationPlanMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
