import React from 'react';
import {util} from "../../util/util";
import {IntakeIntervalComponent} from "./IntakeIntervalComponent";

class DisobeyedMedPlanComponenet extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            disobeyedMedPlan: props.disobeyedMedPlan
        }
    }

    componentWillReceiveProps(nextProps, nextContext) {
        this.setState({disobeyedMedPlan: nextProps.disobeyedMedPlan});
    }

    render() {
        const {disobeyedMedPlan} = this.state;

        const {medPlanSoapDto, intervals} = disobeyedMedPlan;

        const intervalsContent = intervals.map((interval, key) => {
           return (
               <IntakeIntervalComponent intakeInterval={interval} key={key}/>
           )
        });

        return (
            <div className={"card"}>
                <div className={"card-body text-center"}>
                    Start date:<strong>{util.parseDateToString(medPlanSoapDto.startDate)}</strong> <br/>
                    End date:<strong>{util.parseDateToString(medPlanSoapDto.endDate)}</strong> <br/>
                    Intake interval Period:<strong>{medPlanSoapDto.intakeIntervalPeriod}</strong> <br/>
                    Intervals:
                    <div style={{display:'flex'}}>
                        {intervalsContent}
                    </div>
                </div>
            </div>
        )
    }
}

export {DisobeyedMedPlanComponenet}