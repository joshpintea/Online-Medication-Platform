import {baseService} from "./base.service";
import {constants} from "../AppConstants";

export const sideEffectService = {
    getAll,
    deleteObj,
    saveObj
};

function getAll() {
    return baseService.getMethod(constants.routes.api.sideEffectUrl);
}

function deleteObj(id) {
    return baseService.deleteMethod(constants.routes.api.sideEffectUrl, id);
}

function saveObj(obj) {
    return baseService.postMethod(constants.routes.api.sideEffectUrl, obj);
}