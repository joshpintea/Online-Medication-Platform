import React from 'react';

import './index.css';

class IntakeIntervalComponent extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            intakeInterval: props.intakeInterval
        }
    }

    componentWillReceiveProps(nextProps, nextContext) {
        this.setState({intakeInterval: nextProps.intakeInterval});
    }

    render() {
        const {intakeInterval} = this.state;
        console.log(intakeInterval);
        return (
            <div className={"intake_interval"} style={{background: intakeInterval.takenOnTime ? "green": "red"}}>
                Start: <strong>{intakeInterval.intakeIntervalStart}</strong> <br/>
                End: <strong>{intakeInterval.intakeIntervalEnd}</strong> <br/>
            </div>
        )
    }
}

export {IntakeIntervalComponent}