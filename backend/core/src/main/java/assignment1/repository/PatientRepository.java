package assignment1.repository;

import assignment1.entities.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends BaseRepository<Patient> {
    List<Patient> getAllByCaregiverId(Long id);
    Optional<Patient> findById(Long id);
}
