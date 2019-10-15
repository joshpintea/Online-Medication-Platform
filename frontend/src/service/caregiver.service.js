import {constants} from "../AppConstants";
import {baseService} from "./base.service";

export const caregiverService = {
    getAll,
    deleteObj,
    saveObj
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