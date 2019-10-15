import React from 'react';
import {BaseUpdateModel} from "./BaseUpdateModel";
import {sideEffectService} from "../../../service/sideeffect.service";
import Select from "react-select";
import {drugService} from "../../../service";


class DrugModal extends BaseUpdateModel {

    constructor(props) {
        super(props);

        this.state = {
            submitted: false,
            loading: false,
            error: '',
            sideEffects: [],
            sideEffectsSelected: []
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChangeOnSideEffects = this.handleChangeOnSideEffects.bind(this);
    }

    componentWillReceiveProps(nextProps) {
        let sideEffectsSelected = [];
        if (nextProps.show) {
            sideEffectsSelected = nextProps.obj.sideEffects.map((sideEffect) => ({
                value: sideEffect.id,
                label: sideEffect.description
            }));
        }


        this.setState({show: nextProps.show, obj: nextProps.obj, sideEffectsSelected: sideEffectsSelected});
    }

    componentDidMount() {
        sideEffectService.getAll().then(
            sideEffects => {
                this.setState({sideEffects: sideEffects})
            }
        );


    }

    handleSubmit(e) {
        e.preventDefault();
        const {obj, sideEffectsSelected} = this.state;

        obj.sideEffects = sideEffectsSelected.map((sideEffect) => ({
            id: sideEffect.value,
            description: sideEffect.label
        }));


        if (!obj.name) {
            this.setState({submitted: true});
            return;
        }
        this.setState({loading: true});

        drugService.saveObj(obj).then(
            objUpdated => {
                this.props.callbackUpdateObject(objUpdated);
            }, err => {
                this.setState({error: err});
            }
        ).finally(
            this.setState({loading: false, submitted: false})
        )
    }

    handleChangeOnSideEffects = sideEffectsSelected => {
        this.setState({sideEffectsSelected});
    };

    getContentForm() {
        const {obj, submitted, loading, error, sideEffects, sideEffectsSelected} = this.state;

        const sideEffectsOptions = sideEffects.map((sideEffect) => ({
            value: sideEffect.id,
            label: sideEffect.description
        }));

        return (
            <form name={"form"} onSubmit={this.handleSubmit}>
                <div className={'form-group' + (!obj.name && submitted) ? 'has-error' : ''}>
                    <label htmlFor="name">Name</label>
                    <input type={'text'} className={'form-control'} name={'name'} value={obj.name}
                           onChange={this.handleChange}/>
                    {submitted && !obj.name &&
                    <div className="help-block">Name is required</div>
                    }
                </div>

                <div className={'form-group' + (!obj.dosage && submitted) ? 'has-error' : ''}>
                    <label htmlFor="dosage">Dosage</label>
                    <input type={'number'} className={'form-control'} name={'dosage'} value={obj.dosage}
                           onChange={this.handleChange}/>
                    {submitted && !obj.dosage &&
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

export {DrugModal}