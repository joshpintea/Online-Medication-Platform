import {BaseUpdateModel} from "./BaseUpdateModel";
import React from "react";
import {caregiverService, patientService} from "../../../service";
import Select from "react-select";
import {util} from "../../../util";

class PatientModal extends BaseUpdateModel {

    constructor(props) {
        super(props);

        let value = 0, label = 'M';
        if (this.state.obj.gender === 'F') {
            value = 1;
            label = 'M';
        }

        this.state = {
            submitted: false,
            loading: false,
            error: '',
            genderList: ['M', 'F'],
            caregiversList: [],
            caregiverSelected: {},
            gender: {value: value, label: label},
            birthDate: '',
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChangeCustom = this.handleChangeCustom.bind(this);
    }

    componentDidMount() {
        caregiverService.getAll().then(
            caregivers => {
                this.setState({caregiversList: caregivers});
            }
        );
    }


    componentWillReceiveProps(nextProps) {
        super.componentWillReceiveProps(nextProps);
        if (nextProps.show) {

            const caregiverSelected = {
                value: nextProps.obj.caregiverDto.id,
                label: nextProps.obj.caregiverDto.name
            };

            const date = new Date(nextProps.obj.birthDate);


            const dateAsString = util.leftPad(date.getFullYear(),4)
                                            + '-' + util.leftPad(date.getMonth() + 1, 2)
                                            + '-' + util.leftPad(date.getDate(), 2);


            this.setState({caregiverSelected: caregiverSelected, birthDate: dateAsString})
        }
    }

    handleSubmit(e) {
        e.preventDefault();
        const {obj, caregiverSelected, caregiversList, birthDate} = this.state;

        if (!obj.username || !obj.address || !obj.name || !birthDate) {
            this.setState({submitted: true});
            return;
        }
        this.setState({loading: false});

        let caregiverModel = {};
        for (let i = 0; i < caregiversList.length; i++) {
            if (caregiversList[i].id === caregiverSelected.value) {
                caregiverModel = caregiversList[i];
                break;
            }
        }

        obj.birthDate = new Date(birthDate).getTime();
        obj.caregiverDto = caregiverModel;

        patientService.saveObj(obj).then(
            objUpdated => {
                this.props.callbackUpdateObject(objUpdated);
            }, err => {
                this.setState({error: err});
            }
        ).finally(
            this.setState({loading: false, submitted: false})
        )
    }

    handleGenderChange = gender => {
        this.setState({gender: gender});
    };

    handleCaregiverChange = caregiverSelected => {
        this.setState({caregiverSelected: caregiverSelected});
    };

    handleChangeCustom(e) {
        const {name, value} = e.target;
        this.setState({[name]: value});
    }

    getContentForm() {
        const {obj, gender, submitted, loading, error, caregiversList, caregiverSelected, birthDate} = this.state;
        const genderList = ['M', 'F'];
        console.log(birthDate);
        const genderOptions = genderList.map((g, i) => ({
            value: i,
            label: g
        }));

        const caregiverOptions = caregiversList.map( (cg) => ({
            value: cg.id,
            label: cg.name
        }));

        return (
            <form name={"form"} onSubmit={this.handleSubmit}>
                <div className={'form-group' + (!obj.username && submitted) ? 'has-error' : ''}>
                    <label htmlFor="username">Username</label>
                    <input type={'text'} className={'form-control'} name={'username'} value={obj.username}
                           onChange={this.handleChange}/>
                    {submitted && !obj.username &&
                    <div className="help-block">Username is required</div>
                    }
                </div>

                <div className={'form-group' + (!obj.name && submitted) ? 'has-error' : ''}>
                    <label htmlFor="username">Name</label>
                    <input type={'text'} className={'form-control'} name={'name'} value={obj.name}
                           onChange={this.handleChange}/>
                    {submitted && !obj.name &&
                    <div className="help-block">Name is required</div>
                    }
                </div>

                <div className={'form-group' + (!obj.address && submitted) ? 'has-error' : ''}>
                    <label htmlFor="address">Address</label>
                    <input type={'text'} className={'form-control'} name={'address'} value={obj.address}
                           onChange={this.handleChange}/>
                    {submitted && !obj.address &&
                    <div className="help-block">Address is required</div>
                    }
                </div>

                <div className={'form-group' + (!birthDate && submitted) ? 'has-error' : ''}>
                    <label htmlFor="birthDate">BirthDate</label>
                    <input type={'date'} className={'form-control'} name={'birthDate'} value={birthDate}
                           onChange={this.handleChangeCustom}/>
                    {submitted && !birthDate &&
                    <div className="help-block">birthDate is required</div>
                    }
                </div>

                <div className={'form-group' + (!gender && submitted) ? 'has-error' : ''}>
                    <label htmlFor="gender">Gender</label>
                    <Select options={genderOptions} value={gender} onChange={this.handleGenderChange}/>
                </div>

                <div className={'form-group' + (!caregiverSelected && submitted) ? 'has-error' : ''}>
                    <label htmlFor="gender">Caregiver</label>
                    <Select options = {caregiverOptions} value={caregiverSelected} onChange={this.handleCaregiverChange}/>
                </div>

                <div className={'form-group'}>
                    <button className={'btn btn-primary'} disabled={loading}>
                        Update
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
        );
    }
}

export {PatientModal}