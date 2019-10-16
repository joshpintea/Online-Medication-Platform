import {baseService} from "./base.service";
import {constants} from "../AppConstants";


export const doctorService = {
    createMedicationPlan
};

function createMedicationPlan(obj) {
    return baseService.postMethod(constants.routes.api.createMedicationPlan, obj);
}