import React from "react";
import {sideEffectService} from "../../../service/sideeffect.service";


class SideEffectForm extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            description: '',
            submitted: false,
            loading: false,
            error: '',
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleSubmit(e) {
        e.preventDefault();
        const {description} = this.state;
        if (!description) {
            this.setState({submitted: true});
            return;
        }

        this.setState({loading: true});

        sideEffectService.saveObj({id:null, description: description}).then(
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

    render() {
        const {description: description, submitted, loading, error} = this.state;

        return (
            <form name={"form"} onSubmit={this.handleSubmit}>
                <div className={'form-group' + (!description && submitted) ? 'has-error' : ''}>
                    <label htmlFor="description">Description</label>
                    <input type={'text'} className={'form-control'} name={'description'} value={description}
                           onChange={this.handleChange}/>
                    {submitted && !description &&
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
        )
    }
}

export {SideEffectForm}