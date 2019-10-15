import {BaseUpdateModel} from "./BaseUpdateModel";
import React from "react";
import Select from "react-select";
import {caregiverService, patientService} from "../../../service";

class CaregiverModal extends BaseUpdateModel {

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
            gender: {value: value, label: label}
        };


        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(e) {
        e.preventDefault();
        const {obj} = this.state;

        if (!obj.username || !obj.address || !obj.name || !obj.birthDate) {
            this.setState({submitted: true});
            return;
        }
        this.setState({loading: false});

        caregiverService.saveObj(obj).then(
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

    getContentForm() {
        const {obj, gender, submitted, loading, error} = this.state;

        const genderList = ['M', 'F'];

        const genderOptions = genderList.map((g, i) => ({
            value: i,
            label: g
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

                <div className={'form-group' + (!obj.birthDate && submitted) ? 'has-error' : ''}>
                    <label htmlFor="birthDate">BirthDate</label>
                    <input type={'date'} className={'form-control'} name={'birthDate'} value={obj.birthDate}
                           onChange={this.handleChange}/>
                    {submitted && !obj.birthDate &&
                    <div className="help-block">birthDate is required</div>
                    }
                </div>

                <div className={'form-group' + (!gender && submitted) ? 'has-error' : ''}>
                    <label htmlFor="gender">Gender</label>
                    <Select options={genderOptions} value={gender} onChange={this.handleGenderChange}/>
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

export {CaregiverModal}