package assignment1.service.doctor;

import assignment1.dto.DoctorDto;
import assignment1.dto.MedicationPlanDto;
import assignment1.dto.mapper.DoctorMapper;
import assignment1.dto.mapper.MedicationPlanMapper;
import assignment1.entities.Doctor;
import assignment1.entities.MedicationPlan;
import assignment1.exception.ObjectNotFound;
import assignment1.repository.DoctorRepository;
import assignment1.repository.MedicationPlanRepository;
import assignment1.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService, CrudService<DoctorDto> {
    private DoctorRepository doctorRepository;
    private MedicationPlanRepository medicationPlanRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository, MedicationPlanRepository medicationPlanRepository) {
        this.doctorRepository = doctorRepository;
        this.medicationPlanRepository = medicationPlanRepository;
    }

    @Override
    public List<DoctorDto> getAll() {
        return this.doctorRepository.findAll()
                .stream().map(DoctorMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDto getOne(Long id) throws ObjectNotFound {
        Doctor doctor = this.doctorRepository.getOne(id);
        if (doctor == null) {
            throw new ObjectNotFound("Doctor not found");
        }
        return DoctorMapper.convertToDto(doctor);
    }

    @Override
    public void delete(Long id) throws ObjectNotFound {
        Doctor doctor = this.doctorRepository.getOne(id);
        if (doctor == null) {
            throw new ObjectNotFound("Doctor not found");
        }

        this.doctorRepository.delete(doctor);
    }

    @Override
    public DoctorDto save(DoctorDto obj) {
        // @todo check if username is unique, now return internal server error
        Doctor doctor = DoctorMapper.convertToEntity(obj);

        return DoctorMapper.convertToDto(this.doctorRepository.save(doctor));
    }

    @Override
    public MedicationPlanDto createMedicationPlan(MedicationPlanDto medicationPlanDto) {
        MedicationPlan medicationPlan = MedicationPlanMapper.convertToEntity(medicationPlanDto);

        return MedicationPlanMapper.convertToDto(this.medicationPlanRepository.save(medicationPlan));
    }
}
