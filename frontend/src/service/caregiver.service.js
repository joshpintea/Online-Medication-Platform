import {constants} from "../AppConstants";
import {baseService} from "./base.service";

export const caregiverService = {
    getAll,
    deleteObj,
    saveObj,
    getCaregiverPatient: getCaregiverPatients,
    getRecommendationsForPatient: getRecommendationForPatient
};

function getAll() {
    return baseService.getMethod(constants.routes.api.caregiverUrl);
}

function deleteObj(id) {
    return baseService.deleteMethod(constants.routes.api.caregiverUrl, id);
}

function saveObj(obj) {
    return baseService.postMethod(constants.routes.api.caregiverUrl, obj);
}

function getCaregiverPatients(caregiverId) {
    const url = constants.routes.api.getCaregiverPatientsUrl + caregiverId;
    return baseService.getMethod(url);
}

function getRecommendationForPatient(patientId) {
    const url = constants.routes.api.getActivitiesRecommendationForPatient + patientId;
    return baseService.getMethod(url);
}