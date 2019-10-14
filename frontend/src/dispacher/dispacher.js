import {constants} from "../AppConstants";
import {LoginPage} from "../LoginPage";
import {DoctorApp} from "../DoctorApp";
import {PatientApp} from "../PatientApp";
import {CaregiverApp} from "../CaregiverApp";

export function dispatchRoutesByUser(role) {

    let pathAndComponent = {};

    switch (role) {
        case 'ROLE_DOCTOR':
            pathAndComponent.path = routeToPath.ROLE_DOCTOR;
            pathAndComponent.component = DoctorApp;
            break;
        case 'ROLE_PATIENT':
            pathAndComponent.path = routeToPath.ROLE_PATIENT;
            pathAndComponent.component = PatientApp;
            break;
        case 'ROLE_CAREGIVER':
            pathAndComponent.path = routeToPath.ROLE_CAREGIVER;
            pathAndComponent.component = CaregiverApp;
            break;
        default:
            pathAndComponent.path = constants.routes.app.login;
            pathAndComponent.component = LoginPage;
    }

    return pathAndComponent;
}


export const routeToPath = {
  ROLE_DOCTOR: constants.routes.app.doctorBaseUrl,
  ROLE_PATIENT: constants.routes.app.patientBaseUrl,
  ROLE_CAREGIVER: constants.routes.app.caregiverBaseUrl
};
