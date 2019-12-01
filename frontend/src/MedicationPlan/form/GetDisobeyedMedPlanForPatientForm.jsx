import React from 'react';
import {util} from "../../util";
import {doctorService} from "../../service";
import Select from "react-select";

class GetDisobeyedMedPlanForPatientForm extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            patients: props.patients,
            patientSelected: {},
            dateSelected: "",
            submitted: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    componentWillReceiveProps(nextProps, nextContext) {
        this.setState({patients: nextProps.patients});
    }

    handlePatientChange = patientSelected => {
        this.setState({patientSelected});
    };

    handleChange(e) {
        const {name, value} = e.target;

        this.setState({[name]: value});
    }

    handleSubmit(e) {
        e.preventDefault();


        const {patientSelected, dateSelected} = this.state;
        if (util.objectIsEmpty(patientSelected) || !dateSelected) {
            this.setState({submitted: true});
            return;
        }

        doctorService.getNotObeyedMedPlans(this.state.patientSelected.value, dateSelected)
            .then(
                disObeyedMedPlans => {
                    this.props.callback(disObeyedMedPlans);
                }
            );
    }

    render() {
        const {patients, patientSelected, dateSelected, submitted} = this.state;

        const patientsOptions = patients.map( (patient) => ({
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

                <div className={'form-group' + (!dateSelected && submitted) ? 'has-error' : ''}>
                    <label htmlFor="startDate">Date</label>
                    <input type={'date'} className={'form-control'} name={'dateSelected'} value={dateSelected}
                           onChange={this.handleChange}/>
                    {submitted && !dateSelected &&
                    <div className="help-block">Date is required is required</div>
                    }
                </div>
                <div className={'form-group'}>
                    <button className={'btn btn-primary'}>
                        Get med plans
                    </button>
                </div>
            </form>
        )
    }
}

export {GetDisobeyedMedPlanForPatientForm};