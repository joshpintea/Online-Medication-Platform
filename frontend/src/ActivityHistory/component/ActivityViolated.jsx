import React from 'react';
import {util} from "../../util/util";
import {doctorService} from "../../service";
import {AddActivityRecommendationForm} from "../form";

class ActivityViolated extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            activity: props.activity
        };

        this.labelActivity = this.labelActivity.bind(this);
    }

    componentWillReceiveProps(nextProps, nextContext) {
        this.setState({activity: nextProps.activity});
    }

    labelActivity() {
        doctorService.annotateActivity({
            activityId: this.state.activity.id,
            label: !this.state.activity.normal
        }).then(activity => {
            this.setState({activity: activity});
        })
    }

    render() {
        const {activity} = this.state;

        return (
            <div className="card" style={{height:300, width:250, margin: 20}}>
                <div className="card-body text-center">

                    <h5>
                        <strong>
                            {activity.activityLabel} - {activity.id}
                        </strong>
                    </h5>

                    <strong>Start: {util.parseDateTimeToString(util.utcTimeStampToLocalTimestamp(activity.start))}</strong> <br/>
                    <strong>End: {util.parseDateTimeToString(util.utcTimeStampToLocalTimestamp(activity.end))}</strong><br/>
                    <strong>Normal: {activity.normal ? "yes": "no"}</strong><br/>
                    <button onClick={this.labelActivity}>
                        Annotate as {activity.normal ? "not normal": "normal"}
                    </button>

                    {!activity.normal &&
                    <AddActivityRecommendationForm activity={activity}/>
                    }
                </div>

            </div>
        )
    }
}

export {ActivityViolated};