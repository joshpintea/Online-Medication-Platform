import React from 'react';
import {doctorService} from "../../service";

class AddActivityRecommendationForm extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            activity: props.activity,
            recommendation: "",
            submitted: false
        };

        this.change = this.change.bind(this);
        this.submit = this.submit.bind(this);
    }

    componentWillReceiveProps(nextProps, nextContext) {
        this.setState({activity: nextProps.activity});
    }

    change(e) {
        const {name, value} = e.target;
        this.setState({[name]: value});
    }

    submit(e) {
        e.preventDefault();
        const {recommendation, activity} = this.state;
        if (!recommendation) {
            this.setState({submitted: true});
            return;
        }

        doctorService.addActivityRecommendation({
            activityId: activity.id,
            message: recommendation
        }).then(
            response => {this.setState({recommendation: ""})}
        )
    }

    render() {
        const {recommendation, submitted} = this.state;

        return (
            <form name={"form"} onSubmit={this.submit}>
                <div className={'form-group' + (!recommendation && submitted) ? 'has-error' : ''}>
                    <label htmlFor="startDate">Add recommendation</label>
                    <input type={'text'} className={'form-control'} name={'recommendation'} value={recommendation}
                           onChange={this.change}/>
                    {submitted && !recommendation &&
                    <div className="help-block">Recommendation is required</div>
                    }
                </div>
                <div className={'form-group'}>
                    <button className={'btn btn-primary'}>
                        Add
                    </button>
                </div>
            </form>
        )
    }
}

export {AddActivityRecommendationForm};