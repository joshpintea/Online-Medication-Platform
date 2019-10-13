package assignment1.service.doctor;

import assignment1.entities.Doctor;
import assignment1.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor create(Doctor doctor) {
        return this.doctorRepository.save(doctor);
    }
}
