import React from 'react';
import {util} from "../util/util";

class MedicationPlanMiniature extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            medicationPlan: props.medicationPlan
        }
    }

    render() {
        const {medicationPlan} = this.state;

        const drugsList = medicationPlan.drugsList.map((drug) => {
            const sideEffectsName = drug.sideEffects.map((sideEffect) => {
                return sideEffect.description;
            });
            return (
                <li>
                    <strong>Name: </strong> {drug.name} <br/>
                    <strong> Dosage: </strong> {drug.dosage} <br/>
                    <strong>Side effects:</strong> {sideEffectsName.join(",")}
                </li>
            )
        });
        return (
            <div className="card">
                <div className="card-body">
                     <strong>Doctor: </strong> {medicationPlan.doctorDto.name} <br/>
                     <strong>Start date: </strong> {util.parseDateToString(medicationPlan.startDate)} <br/>
                     <strong>End date: </strong> {util.parseDateToString(medicationPlan.endDate)} <br/>
                     <strong>Intake interval: </strong> {medicationPlan.intakeInterval} <br/>
                     <strong>Drugs: </strong>
                        <ul>
                            {drugsList}
                        </ul>
                </div>
            </div>
        )
    }
}

export {MedicationPlanMiniature}