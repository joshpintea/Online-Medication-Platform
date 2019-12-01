import {baseService} from "./base.service";
import {constants} from "../AppConstants";


export const doctorService = {
    createMedicationPlan,
    getPatientActivitiesByDay,
    annotateActivity: labelActivity,
    addActivityRecommendation,
    getNotObeyedMedPlans
};

function createMedicationPlan(obj) {
    return baseService.postMethod(constants.routes.api.createMedicationPlan, obj);
}

function getPatientActivitiesByDay(patientId, date) {
    return baseService.getMethod(constants.routes.api.activityByPatientUrl + patientId + '/' + date);
}

function labelActivity(obj) {
    return baseService.postMethod(constants.routes.api.annotateActivityUrl, obj);
}

function addActivityRecommendation(obj) {
    return baseService.postMethod(constants.routes.api.addActivityRecommendation, obj);
}

function getNotObeyedMedPlans(patientId, date) {
    return baseService.getMethod(constants.routes.api.notObeyedMedPlan + patientId + '/' + date);
}