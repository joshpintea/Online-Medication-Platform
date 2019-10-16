import React from 'react'
import {NavBar} from "../NavBar";
import {caregiverService} from "../service";
import {constants} from "../AppConstants";
import {modelsColumnsView} from "../models";
import {MDBIcon} from "mdbreact";
import {util} from "../util";

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
        const {patientsList} = this.state;
        const columns = modelsColumnsView.patient;
        let tableColumns = columns.map ( (column) => {
            return (
                <th scope={"col"}>{column}</th>
            )
        });

        let tableData = patientsList.map ( (objectModel) => {
            let dataColumns = columns.map( (column) => {
                if (column === 'birthDate') {
                    return (
                        <td>
                            {util.parseDateToString(objectModel[column])}
                        </td>
                    )
                }

                return (
                    <td>
                        {objectModel[column]}
                    </td>
                )
            });

            return (
                <tr>
                    {dataColumns}
                </tr>
            )
        });

        return (
            <div>
                <NavBar/>

                <div className={"jumbotron"}>
                    <h1>Patients</h1>

                    <table className={"table"}>
                        <thead>
                            <tr>
                                {tableColumns}
                            </tr>
                        </thead>
                        <tbody>
                                {tableData}
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export {CaregiverApp}