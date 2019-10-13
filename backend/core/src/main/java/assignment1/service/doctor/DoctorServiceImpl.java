package assignment1.service.doctor;

import assignment1.dto.DoctorDto;
import assignment1.dto.mapper.DoctorMapper;
import assignment1.entities.Doctor;
import assignment1.exception.ObjectNotFound;
import assignment1.repository.DoctorRepository;
import assignment1.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService, CrudService<DoctorDto> {
    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
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
        Doctor doctor = DoctorMapper.convertToEntity(obj);

        return DoctorMapper.convertToDto(this.doctorRepository.save(doctor));
    }
}
