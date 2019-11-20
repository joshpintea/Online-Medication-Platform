package assignment1.exception;

public class PatientNotFound extends Exception {
    public PatientNotFound(Long idPatient) {
        super("Patient " + idPatient + " not found");
    }
}
