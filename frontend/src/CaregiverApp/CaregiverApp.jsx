import React from 'react'
import {CaregiverNavBar, NavBar} from "../NavBar";
import {caregiverService} from "../service";
import {constants} from "../AppConstants";
import {BrowserRouter, Switch, Route} from "react-router-dom";
import {CaregiverPatientsPage} from "./CaregiverPatientsPage";
import {CaregiverNotificationPage} from "./CaregiverNotificationPage";
import {NotFoundPage} from "../NotFoundPage";

class CaregiverApp extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            patientsList: []
        }
    }

    componentDidMount() {
        const userLogged = JSON.parse(localStorage.getItem(constants.loggedUser));

        caregiverService.getCaregiverPatient(userLogged.id).then(
            patients => {
                this.setState({patientsList: patients});
            }
        )
    }
    render() {
        return (
            <div>
                <CaregiverNavBar />
                <BrowserRouter>
                    <Switch>
                        <Route exact path={constants.routes.app.caregiverBaseUrl} component={CaregiverPatientsPage}/>
                        <Route exact path={constants.routes.app.activitiesViolatedCaregiver} component={CaregiverNotificationPage}/>
                        <Route component={NotFoundPage}/>
                    </Switch>
                </BrowserRouter>
            </div>
        )
    }
}

export {CaregiverApp}