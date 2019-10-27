package assignment1.repository;

import assignment1.entities.Caregiver;
import assignment1.entities.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaregiverRepository extends BaseRepository<Caregiver> {
}
