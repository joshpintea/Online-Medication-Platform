import React from 'react';

class ActivityComponent extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            activity: props.activity
        }
    }

    componentWillReceiveProps(nextProps, nextContext) {
        this.setState({activity: nextProps.activity});
    }

    render() {
        const {activity} = this.state;

        return (
            <div className={"card"}>
                <div className={"card-body"}>
                    <strong>Activity name:</strong> {activity.activityLabel} <br/>
                    <strong>Start date:</strong> {activity.startDate} <br/>
                    <strong>End date:</strong> {activity.endDate} <br/>
                    <strong>Patient: </strong> {activity.patient.name} - {activity.patient.username} <br/>
                </div>
            </div>
        )
    }
}

export {ActivityComponent};
