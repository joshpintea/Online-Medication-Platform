import React from "react";
import Select from 'react-select';

import {sideEffectService} from "../../../service/sideeffect.service";
import {drugService} from "../../../service";


class DrugForm extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            name: '',
            dosage: 0,
            sideEffects: [],
            sideEffectsSelected: [],
            submitted: false,
            loading: false,
            error: '',
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.handleChangeOnSideEffects = this.handleChangeOnSideEffects.bind(this);
    }

    componentDidMount() {
        sideEffectService.getAll().then(
            sideEffects => {
                this.setState({sideEffects: sideEffects})
            }
        )
    }

    handleSubmit(e) {
        e.preventDefault();
        const {name, dosage, sideEffectsSelected} = this.state;
        const sideEffects = sideEffectsSelected.map((sideEffect) => ({
            id: sideEffect.value,
            description: sideEffect.label
        }));

        if (dosage <= 0) {
            this.setState({error: "Dosage need to be greater than zero"});
            return;
        }

        if (!name || !dosage) {
            this.setState({submitted: true});
            return;
        }

        this.setState({loading: true});

        drugService.saveObj({id: null, name: name, dosage: dosage, sideEffects: sideEffects}).then(
            obj => {
                this.props.callbackNewObject(obj);
                this.setState({name: '', dosage: 0, sideEffectsSelected: []});
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

    handleChangeOnSideEffects = sideEffectsSelected => {
        this.setState({sideEffectsSelected});
    };

    render() {
        const {name, dosage, submitted, loading, error, sideEffects, sideEffectsSelected} = this.state;
        const sideEffectsOptions = sideEffects.map((sideEffect) => ({
            value: sideEffect.id,
            label: sideEffect.description
        }));

        return (
            <form name={"form"} onSubmit={this.handleSubmit}>
                <div className={'form-group' + (!name && submitted) ? 'has-error' : ''}>
                    <label htmlFor="name">Name</label>
                    <input type={'text'} className={'form-control'} name={'name'} value={name}
                           onChange={this.handleChange}/>
                    {submitted && !name &&
                    <div className="help-block">Name is required</div>
                    }
                </div>

                <div className={'form-group' + (!dosage && submitted) ? 'has-error' : ''}>
                    <label htmlFor="dosage">Dosage</label>
                    <input type={'number'} className={'form-control'} name={'dosage'} value={dosage}
                           onChange={this.handleChange}/>
                    {submitted && !dosage &&
                    <div className="help-block">Dosage is required</div>
                    }
                </div>

                <div className={'form-group'}>
                    <label htmlFor="sideEffects">Side effects</label>
                    <Select options={sideEffectsOptions} value={sideEffectsSelected} isMulti
                            onChange={this.handleChangeOnSideEffects}/>
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

export {DrugForm}