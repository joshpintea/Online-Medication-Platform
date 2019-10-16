import React from "react";
import {caregiverService} from "../../../service";
import Select from "react-select";

class CaregiverForm extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            username: '',
            gender: {value: 0, label: 'M'},
            address: '',
            name: '',
            birthDate: '',
            submitted: false,
            loading: false,
            error: '',
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleSubmit(e) {
        e.preventDefault();
        const {username, gender, address, name, birthDate} = this.state;
        let timestampBirthDate = new Date(birthDate).getTime();

        if (!username || !address || !name || !birthDate) {
            this.setState({submitted: true});
            return;
        }

        this.setState({loading: true});

        caregiverService.saveObj({
            id: null,
            username: username,
            gender: gender.label,
            address: address,
            name: name,
            birthDate: timestampBirthDate,
            userRole: null
        }).then(
            obj => {
                this.props.callbackNewObject(obj);
                this.setState({username: '', address: '', name: '', birthDate: ''});
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

    render() {
        const {username, gender, address, name, birthDate, submitted, loading, error} = this.state;

        const genderList = ['M', 'F'];

        const genderOptions = genderList.map((g, i) => ({
            value: i,
            label: g
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
                    <Select options={genderOptions} value={gender} onChange={this.handleGenderChange}/>
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

export {CaregiverForm}