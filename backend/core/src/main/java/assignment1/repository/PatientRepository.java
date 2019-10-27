package assignment1.repository;

import assignment1.entities.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends BaseRepository<Patient> {
    List<Patient> getAllByCaregiverId(Long id);
}
