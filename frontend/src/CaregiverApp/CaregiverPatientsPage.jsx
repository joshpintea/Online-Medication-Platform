import {constants} from "../AppConstants";
import {caregiverService} from "../service";
import {modelsColumnsView} from "../models";
import {util} from "../util";
import React from "react";
import Select from "react-select";
import {RecommendationComponent} from "./components";


class CaregiverPatientsPage extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            patientsList: [],
            patientSelected: {},
            submitted: false,
            recommendations: []
        };

        this.getRecommendations = this.getRecommendations.bind(this);
    }

    componentDidMount() {
        const userLogged = JSON.parse(localStorage.getItem(constants.loggedUser));

        caregiverService.getCaregiverPatient(userLogged.id).then(
            patients => {
                this.setState({patientsList: patients});
            }
        )
    }

    handlePatientChange = patientSelected => {
        this.setState({patientSelected});
    };

    getRecommendations(e) {
        e.preventDefault();
        const {patientSelected} = this.state;

        if (util.objectIsEmpty(patientSelected)) {
            this.setState({submitted: true});
            return;
        }

        caregiverService.getRecommendationsForPatient(patientSelected.value).then(
            recommendations => {
                this.setState({recommendations: recommendations});
            }
        )
    }

    render() {
        const {patientsList, patientSelected, submitted} = this.state;
        const columns = modelsColumnsView.patient;
        let tableColumns = columns.map((column) => {
            return (
                <th scope={"col"}>{column}</th>
            )
        });

        let tableData = patientsList.map((objectModel) => {
            let dataColumns = columns.map((column) => {
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

        const patientsOptions = patientsList.map( (patient) => ({
            value: patient.id,
            label: patient.name
        }));

        const recommendationsContent = this.state.recommendations.map((recommendation, key) => {
            return (
                <RecommendationComponent recommendation={recommendation} key={key}/>
            )
        });

        return (
            <div>
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

                <div className={"jumbotron"}>
                    <form className={"form"} onClick={this.getRecommendations}>
                        <div className={'form-group' + (util.objectIsEmpty(patientSelected) && submitted) ? 'has-error' : ''}>
                            <label htmlFor="patient">Patient</label>
                            <Select options={patientsOptions} value={patientSelected} onChange={this.handlePatientChange}/>
                            {submitted && util.objectIsEmpty(patientSelected) &&
                            <div className="help-block">Patient is required</div>
                            }
                        </div>

                        <div className={'form-group'}>
                            <button className={'btn btn-primary'}>
                                Get recommendations
                            </button>
                        </div>
                    </form>

                    <div className={"grid-container"}>
                        {recommendationsContent}
                    </div>
                </div>
            </div>
        )
    }
}

export {CaregiverPatientsPage};