import React from "react";
import {caregiverService, patientService} from "../../../service";
import Select from 'react-select';


class PatientForm extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            username: '',
            gender: {value: 0, label: 'M'},
            address: '',
            name: '',
            birthDate: '',
            caregiverSelected: {},
            caregivers: [],
            submitted: false,
            loading: false,
            error: '',
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    componentDidMount() {
        caregiverService.getAll().then(
            caregivers => {
                const caregiverSelected = {
                    value: caregivers[0].id,
                    label: caregivers[0].name
                };

                this.setState({caregivers: caregivers, caregiverSelected: caregiverSelected});
            }
        );
    }

    handleSubmit(e) {
        e.preventDefault();
        const {username, gender, address, name, birthDate, caregiverSelected, caregivers} = this.state;
        let timestampBirthDate = new Date(birthDate).getTime() / 1000;


        if (!username || !address || !name || !birthDate) {
            this.setState({submitted: true});
            return;
        }

        let caregiverModel = {};

        for (let i = 0; i < caregivers.length; i++) {
            if (caregiverSelected.value === caregivers[i].id) {
                caregiverModel = caregivers[i]
            }
        }

        this.setState({loading: true});

        patientService.saveObj({
            id:null,
            username: username,
            gender: gender.label,
            address: address,
            name: name,
            birthDate: timestampBirthDate,
            userRole:null,
            caregiverDto: caregiverModel
        }).then(
            obj => {
                this.props.callbackNewObject(obj);
                this.setState({description: ''});
            }, err => {
                this.setState({error: err});
            }
        ).finally(
            this.setState({loading: false, submitted: false})
        )
    }

    handleChange(e) {
        const {name, value} = e.target;

        this.setState({[name]: value});
    }

    handleGenderChange = gender => {
        this.setState({gender: gender});
    };

    handleCaregiverChange = caregiverSelected => {
        this.setState({caregiverSelected: caregiverSelected});
    };

    render() {
        const {username, gender, address, name, birthDate, submitted, loading, error, caregiverSelected, caregivers} = this.state;

        const genderList = ['M', 'F'];

        const genderOptions = genderList.map((g, i) => ({
            value: i,
            label: g
        }));

        const caregiverOptions = caregivers.map( (cg) => ({
            value: cg.id,
            label: cg.name
        }));

        return (
            <form name={"form"} onSubmit={this.handleSubmit}>
                <div className={'form-group' + (!username && submitted) ? 'has-error' : ''}>
                    <label htmlFor="username">Username</label>
                    <input type={'text'} className={'form-control'} name={'username'} value={username}
                           onChange={this.handleChange}/>
                    {submitted && !username &&
                    <div className="help-block">Username is required</div>
                    }
                </div>

                <div className={'form-group' + (!name && submitted) ? 'has-error' : ''}>
                    <label htmlFor="username">Name</label>
                    <input type={'text'} className={'form-control'} name={'name'} value={name}
                           onChange={this.handleChange}/>
                    {submitted && !name &&
                    <div className="help-block">Name is required</div>
                    }
                </div>

                <div className={'form-group' + (!address && submitted) ? 'has-error' : ''}>
                    <label htmlFor="address">Address</label>
                    <input type={'text'} className={'form-control'} name={'address'} value={address}
                           onChange={this.handleChange}/>
                    {submitted && !address &&
                    <div className="help-block">Address is required</div>
                    }
                </div>

                <div className={'form-group' + (!birthDate && submitted) ? 'has-error' : ''}>
                    <label htmlFor="birthDate">BirthDate</label>
                    <input type={'date'} className={'form-control'} name={'birthDate'} value={birthDate}
                           onChange={this.handleChange}/>
                    {submitted && !birthDate &&
                    <div className="help-block">birthDate is required</div>
                    }
                </div>

                <div className={'form-group' + (!gender && submitted) ? 'has-error' : ''}>
                    <label htmlFor="gender">Gender</label>
                    <Select options = {genderOptions} value={gender} onChange={this.handleGenderChange}/>
                </div>

                <div className={'form-group' + (!caregiverSelected && submitted) ? 'has-error' : ''}>
                    <label htmlFor="gender">Caregiver</label>
                    <Select options = {caregiverOptions} value={caregiverSelected} onChange={this.handleCaregiverChange}/>
                </div>

                <div className={'form-group'}>
                    <button className={'btn btn-primary'} disabled={loading}>
                        Create
                    </button>
                    {
                        loading &&
                        <img
                            src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA=="/>
                    }
                </div>
                {error &&
                <div className={'alert alert-danger'}>{error}</div>
                }
            </form>
        )
    }
}

export {PatientForm}