import * as React from "react";
import {constants} from "../AppConstants";


class DoctorDashboard extends React.Component {

    render() {

        const models = [
            {modelName: 'Patient', url: constants.routes.app.patientCrudUrl},
            {modelName: 'Caregiver', url: constants.routes.app.caregiverCrudUrl},
            {modelName: 'Drug', url: constants.routes.app.drugCrudUrl},
            {modelName: 'Side effect', url: constants.routes.app.sideEffectCrudUrl},
        ];

        const tableContent = models.map((model, index) => {
                return (
                    <tr>
                        <th scope={"row"}>{index}</th>
                        <td>{model.modelName}</td>
                        <td>
                            <a type="button" className="btn btn-light" href={model.url}>Go</a>
                        </td>
                    </tr>
                )
            }
        );
        return (
            <div className={"jumbotron"}>
                <h1>Models</h1>

                <table className="table table-dark">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Model name</th>
                        <th scope="col">Display</th>
                    </tr>
                    </thead>
                    <tbody>
                        {tableContent}
                    </tbody>
                </table>
            </div>
        );
    }
}

export {DoctorDashboard}