import React from 'react'
import {NavBar} from "../NavBar";
import {NotFoundPage} from "../NotFoundPage";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import {DoctorDashboard} from "./DoctorDashboard";
import {constants} from "../AppConstants";
import {ModelCrudComponent} from "./ModelComponent";
import {modelsColumnsView} from "../models";
import {caregiverService, drugService, patientService} from "../service";
import {sideEffectService} from "../service/sideeffect.service";
import {CaregiverForm, DrugForm, SideEffectForm} from "./ModelComponent/CreateForm";
import {PatientForm} from "./ModelComponent/CreateForm/PatientForm";
import {CaregiverModal, DrugModal, PatientModal, SideEffectModal} from "./ModelComponent/UpdateModal";
import {ActivitiesViolatedPage, ActivityHistoryPage} from "../ActivityHistory";
import {DisobeyedMedPlanPage} from "../MedicationPlan";


class DoctorApp extends React.Component {
    render() {
        return (
            <div>
                <NavBar/>
                <Router>
                    <Switch>
                        <Route exact path={constants.routes.app.doctorDashboard} component={DoctorDashboard}/>
                        <Route exacat path={constants.routes.app.activitiesHistory} component={ActivityHistoryPage}/>
                        <Route exact path={constants.routes.app.activitiesViolated} component={ActivitiesViolatedPage}/>
                        <Route exact path={constants.routes.app.disobeyedMedPlans} component={DisobeyedMedPlanPage}/>
                        <Route path={constants.routes.app.drugCrudUrl}
                               component={() => <ModelCrudComponent modelName={"Drug"} columns={modelsColumnsView.drug}
                                                                    service={drugService}
                                                                    CreateComponent={DrugForm}
                                                                    UpdateComponent={DrugModal}
                               />}
                        />
                        <Route path={constants.routes.app.sideEffectCrudUrl}
                               component={() => <ModelCrudComponent modelName={"Side effect"}
                                                                    columns={modelsColumnsView.sideEffect}
                                                                    service={sideEffectService}
                                                                    CreateComponent={SideEffectForm}
                                                                    UpdateComponent={SideEffectModal}

                               />}
                        />

                        <Route path={constants.routes.app.patientCrudUrl}
                               component={() => <ModelCrudComponent modelName={"Patient"}
                                                                    columns={modelsColumnsView.patient}
                                                                    service={patientService}
                                                                    CreateComponent={PatientForm}
                                                                    UpdateComponent={PatientModal}
                               />}
                        />
                        <Route path={constants.routes.app.caregiverCrudUrl}
                               component={() => <ModelCrudComponent modelName={"Caregiver"}
                                                                    columns={modelsColumnsView.caregiver}
                                                                    service={caregiverService}
                                                                    CreateComponent={CaregiverForm}
                                                                    UpdateComponent={CaregiverModal}
                               />}
                        />
                        <Route component={NotFoundPage}/>
                    </Switch>
                </Router>
            </div>
        )
    }
}

export {DoctorApp}