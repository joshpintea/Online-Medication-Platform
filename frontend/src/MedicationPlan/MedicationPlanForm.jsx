import React from 'react'
import Select from "react-select";
import {doctorService, drugService, patientService} from "../service";
import {constants} from "../AppConstants";
import {util} from "../util/util";

class MedicationPlanForm extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            listOfPatients: [],
            listOfDrugs: [],
            intakeInterval: '',
            startDate: "",
            endDate: "",
            patientSelected: {},
            drugsSelected: [],
            submitted: false,
            error: '',
            success: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount() {
        patientService.getAll().then(
            patients => {
                this.setState({listOfPatients: patients});
            }
        );

        drugService.getAll().then(
            drugs => {
                this.setState({listOfDrugs: drugs});
            }
        );
    }

    handlePatientChange = patientSelected => {
        this.setState({patientSelected});
    };

    handleDrugsChange = drugsSelected => {
        this.setState({drugsSelected});
    };


    handleChange(e) {
        const {name, value} = e.target;

        this.setState({[name]: value});
    }


    handleSubmit(e) {
        e.preventDefault();

        const {listOfPatients, listOfDrugs} = this.state;
        const {patientSelected, drugsSelected} = this.state;
        const {startDate, endDate, intakeInterval} = this.state;
        const doctor = JSON.parse(localStorage.getItem(constants.loggedUser));


        let startDateTimestamp = new Date(startDate).getTime();
        let endDateTimestamp = new Date(endDate).getTime();

        if (util.objectIsEmpty(patientSelected) || drugsSelected.length===0 || !startDate
                || !endDate || !intakeInterval
        ) {
            this.setState({submitted: true});
            return;
        }
        if (startDateTimestamp > endDateTimestamp) {
            this.setState({error: "Start date need to be smaller than end date"});
            return ;
        }


        let patient = {};
        for (let i = 0; i < listOfPatients.length; i++) {
            if (listOfPatients[i].id === patientSelected.value) {
                patient = listOfPatients[i];
            }
        }

        let drugsList = [];

        for (let i = 0; i < listOfDrugs.length; i++) {
            for (let j = 0; j < drugsSelected.length; j++) {
                if (drugsSelected[j].value === listOfDrugs[i].id) {
                    drugsList.push(listOfDrugs[i]);
                }
            }
        }

        const obj = {
            id: null,
            startDate: startDateTimestamp,
            endDate: endDateTimestamp,
            intakeInterval: intakeInterval,
            doctorDto: doctor,
            drugsList: drugsList,
            patientDto: patient
        };

        doctorService.createMedicationPlan(obj).then(
            response => {
                this.setState({
                    success: 'Medication plan created',
                    intakeInterval: 0,
                    startDate: '',
                    endDate: '',
                    drugsSelected: [],
                    patientSelected: []
                })
            },
            error => {
                this.setState({error:error, success: ''});
            }
        )

    }

    render() {
        const {intakeInterval, startDate, endDate, patientSelected, drugsSelected, submitted, error} = this.state;
        const {success} = this.state;
        const patientsOptions = this.state.listOfPatients.map( (patient) => ({
            value: patient.id,
            label: patient.name
        }));

        const drugsOptions = this.state.listOfDrugs.map( (patient) => ({
            value: patient.id,
            label: patient.name
        }));

        return (
            <form name={"form"} onSubmit={this.handleSubmit}>
                <div className={'form-group' + (util.objectIsEmpty(patientSelected) && submitted) ? 'has-error' : ''}>
                    <label htmlFor="patient">Patient</label>
                    <Select options={patientsOptions} value={patientSelected} onChange={this.handlePatientChange}/>
                    {submitted && util.objectIsEmpty(patientSelected) &&
                    <div className="help-block">Patient is required</div>
                    }
                </div>


                <div className={'form-group' + (drugsSelected.length === 0 && submitted) ? 'has-error' : ''}>
                    <label htmlFor="patient">Drugs</label>
                    <Select options={drugsOptions} value={drugsSelected} onChange={this.handleDrugsChange} isMulti/>
                    {submitted && drugsSelected.length === 0 &&
                    <div className="help-block">Drugs are required</div>
                    }
                </div>

                <div className={'form-group' + (!startDate && submitted) ? 'has-error' : ''}>
                    <label htmlFor="startDate">Start date</label>
                    <input type={'date'} className={'form-control'} name={'startDate'} value={startDate}
                           onChange={this.handleChange}/>
                    {submitted && !startDate &&
                    <div className="help-block">Start date is required</div>
                    }
                </div>

                <div className={'form-group' + (!endDate && submitted) ? 'has-error' : ''}>
                    <label htmlFor="startDate">End date</label>
                    <input type={'date'} className={'form-control'} name={'endDate'} value={endDate}
                           onChange={this.handleChange}/>
                    {submitted && !endDate &&
                    <div className="help-block">End date is required</div>
                    }
                </div>

                <div className={'form-group' + (!endDate && submitted) ? 'has-error' : ''}>
                    <label htmlFor="intakeInterval">Intake interval</label>
                    <input type={'number'} className={'form-control'} name={'intakeInterval'} value={intakeInterval}
                           onChange={this.handleChange}/>
                    {submitted && !intakeInterval &&
                    <div className="help-block">Intake interval is required</div>
                    }
                </div>


                <div className={'form-group'}>
                    <button className={'btn btn-primary'}>
                        Create
                    </button>
                </div>
                {error &&
                <div className={'alert alert-danger'}>{error}</div>
                }

                {success &&
                <div className={"alert alert-success"}> {success}</div>
                }
            </form>
        )
    }
}

export {MedicationPlanForm}