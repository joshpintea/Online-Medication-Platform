import React from 'react';
import {GetDisobeyedMedPlanForPatientForm} from "./form";
import {patientService} from "../service";
import {DisobeyedMedPlanComponenet} from "./component";

class DisobeyedMedPlanPage extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            patients: [],
            disobeyedMedicationPlans: []
        };

        this.setDisobeyedMedicationPlan = this.setDisobeyedMedicationPlan.bind(this);
    }


    componentDidMount() {
        patientService.getAll().then(
            patients => {
                this.setState({patients: patients});
            }
        )
    }

    setDisobeyedMedicationPlan(disobeyedMedPlanList) {
        this.setState({disobeyedMedicationPlans: disobeyedMedPlanList});
    }

    render() {
        const {patients, disobeyedMedicationPlans} = this.state;

        const disobeyedListContent = disobeyedMedicationPlans.map( (disobeyedMedPlan, key) => {
            return (
                <DisobeyedMedPlanComponenet disobeyedMedPlan={disobeyedMedPlan} key={key}/>
            )
        });

        return (
            <div>
                <div className={"jumbotron"}>
                    <GetDisobeyedMedPlanForPatientForm patients={patients} callback={this.setDisobeyedMedicationPlan}/>

                    {disobeyedListContent}
                </div>
            </div>
        )
    }
}

export {DisobeyedMedPlanPage};