import React from 'react';
import {BaseUpdateModel} from "./BaseUpdateModel";
import {sideEffectService} from "../../../service/sideeffect.service";


class SideEffectModal extends BaseUpdateModel {

    constructor(props) {
        super(props);

        this.state = {
            submitted: false,
            loading: false,
            error: ''
        };
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(e) {
        e.preventDefault();
        const {obj} = this.state;

        if (!obj.description) {
            this.setState({submitted: true});
            return;
        }
        this.setState({loading: false});

        sideEffectService.saveObj(obj).then(
            objUpdated => {
                this.props.callbackUpdateObject(objUpdated);
            }, err => {
                this.setState({error: err});
            }
        ).finally(
            this.setState({loading: false, submitted: false})
        )
    }

    getContentForm() {
        const {obj, submitted, loading, error} = this.state;
        return (
            <form name={"form"} onSubmit={this.handleSubmit}>
                <div className={'form-group' + (!obj.description && submitted) ? 'has-error' : ''}>
                    <label htmlFor="description">Description</label>
                    <input type={'text'} className={'form-control'} name={'description'} value={obj.description}
                           onChange={this.handleChange}/>
                    {submitted && !obj.description &&
                    <div className="help-block">Description is required</div>
                    }
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
        );
    }
}

export {SideEffectModal}