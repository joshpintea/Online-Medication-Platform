package assignment1.repository;

import assignment1.entities.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends BaseRepository<Patient> {
}
