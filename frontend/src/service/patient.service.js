import {baseService} from "./base.service";
import {constants} from "../AppConstants";

export const patientService = {
    getAll,
    deleteObj,
    saveObj
};

function getAll() {
    return baseService.getMethod(constants.routes.api.patientUrl);
}

function deleteObj(id) {
    return baseService.deleteMethod(constants.routes.api.patientUrl, id);
}

function saveObj(obj) {
    return baseService.postMethod(constants.routes.api.patientUrl, obj);
}