import {authHeader, handleResponse} from "../util";
import {constants} from "../AppConstants";
import {baseService} from "./base.service";

export const drugService = {
    getAll,
    deleteObj,
    saveObj
};

function getAll() {
    return baseService.getMethod(constants.routes.api.drugUrl);
}

function deleteObj(id) {
    return baseService.deleteMethod(constants.routes.api.drugUrl, id);
}

function saveObj(obj) {
    return baseService.postMethod(constants.routes.api.drugUrl, obj);
}