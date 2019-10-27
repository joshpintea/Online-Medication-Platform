package assignment1.service.caregiver;

import assignment1.dto.CaregiverDto;
import assignment1.dto.PatientDto;
import assignment1.dto.mapper.CaregiverMapper;
import assignment1.dto.mapper.PatientMapper;
import assignment1.entities.Caregiver;
import assignment1.entities.User;
import assignment1.exception.ObjectNotFound;
import assignment1.exception.UsernameIsTaken;
import assignment1.repository.CaregiverRepository;
import assignment1.repository.PatientRepository;
import assignment1.service.CrudService;
import assignment1.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaregiverServiceImpl implements CaregiverService, CrudService<CaregiverDto> {

    private CaregiverRepository caregiverRepository;
    private PatientRepository patientRepository;
    private UserService userService;

    public CaregiverServiceImpl(CaregiverRepository caregiverRepository, UserService userService, PatientRepository patientRepository) {
        this.caregiverRepository = caregiverRepository;
        this.userService = userService;
        this.patientRepository = patientRepository;
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
    public CaregiverDto save(CaregiverDto obj) throws UsernameIsTaken {
        Caregiver caregiver = CaregiverMapper.convertToEntity(obj);
        // check if caregiver exist.
        if (caregiver.getId() != null) {
            Caregiver caregiver1 = this.caregiverRepository.getOne(caregiver.getId());

            // update fields that are not into the dto
            if (caregiver1 != null) {
                caregiver.setPassword(caregiver1.getPassword());
            }
        } else {
            User user = this.userService.getUserAfterUsername(caregiver.getUsername());
            if (user != null) {
                throw new UsernameIsTaken();
            }

            caregiver.setPassword("default");
        }


        return CaregiverMapper.convertToDto(this.caregiverRepository.save(caregiver));
    }

    @Override
    public List<PatientDto> getPatientsOfCaregiver(Long id) throws ObjectNotFound {
        Caregiver caregiver = this.caregiverRepository.getOne(id);

        if (caregiver == null) {
            throw new ObjectNotFound("Caregiver not found");
        }

        return this.patientRepository.getAllByCaregiverId(id)
                .stream()
                .map(PatientMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
