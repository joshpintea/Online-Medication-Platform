import React from 'react'
import {NavBar} from "../NavBar";
import {constants} from "../AppConstants";
import {patientService} from "../service";
import {MedicationPlanMiniature} from "../MedicationPlan";
import {util} from "../util/util";

class PatientApp extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            medicationsPlan: [],
            patient: {}
        }
    }

    componentDidMount() {
        const loggedUser = JSON.parse(localStorage.getItem(constants.loggedUser));

        patientService.getMedicationsPlanForPatient(loggedUser.id).then(
            medicationsPlan => {
                this.setState({medicationsPlan: medicationsPlan});
            }, error => {
                console.log(error);
            }
        );

        patientService.getOne(loggedUser.id).then(
            patient => {
                this.setState({patient: patient});
            }, error => {
                console.log(error);
            }
        )
    }

    render() {
        const {medicationsPlan, patient} = this.state;

        const medicationsPlanContent = medicationsPlan.map((medicationPlan) => {
            return (
                <MedicationPlanMiniature medicationPlan={medicationPlan}/>
            )
        });
        return (
            <div>
                <NavBar/>
                { !util.objectIsEmpty(patient) &&
                <div className={"jumbotron"}>
                    <h1>Account details</h1>
                    <div className={"card"}>
                        <div className={"card-body"}>
                            <strong>Caregiver:</strong> {patient.caregiverDto.name} <br/>
                            <strong>Address:</strong> {patient.address} <br/>
                            <strong>Name:</strong> {patient.name} <br/>
                            <strong>Gender:</strong> {patient.gender} <br/>
                        </div>
                    </div>
                </div>
                }

                <div className="jumbotron">
                    <h1>Medication plans</h1>
                    {medicationsPlan.length === 0 &&
                        <div className={"alert alert-danger"}>
                            You are healthy mother fucker
                        </div>
                    }
                    {medicationsPlan.length !== 0 &&
                        medicationsPlanContent
                    }
                </div>

            </div>
        )
    }
}

export {PatientApp}