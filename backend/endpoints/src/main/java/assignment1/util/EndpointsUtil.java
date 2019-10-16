package assignment1.util;

public class EndpointsUtil {
    public static final String API = "/api";

    public static final String DOCTOR = API + "/doctor";
    public static final String CREATE_MEDICATION_PLAN = "/medication";

    public static final String PATIENT = API + "/patient";
    public static final String PATIENT_GET_MEDICATIONS_PLAN = "/medications/{patient_id}";

    public static final String CAREGIVER = API + "/caregiver";
    public static final String CAREGIVER_PATIENTS = "/patients/{id}";


    public static final String DRUG = API + "/drug";

    public static final String USER = API + "/user";
    public static final String LOGGED_USER = "/logged";

    public static final String SIDE_EFFECT = API + "/side_effect";
}
