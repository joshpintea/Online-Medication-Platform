import React from 'react';
import {util} from "../../util/util";

class RecommendationComponent extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            recommendation: props.recommendation
        }
    }

    componentWillReceiveProps(nextProps, nextContext) {
        this.setState({recommendation: nextProps.recommendation});
    }

    render() {
        const {recommendation} = this.state;

        return (
            <div className={"card"}>
                <div className="card-body text-center">
                    Description: <strong>{recommendation.recommendation}</strong><br/>
                    Activity label: <strong>{recommendation.activityDto.activityLabel}</strong><br/>
                    Activity start date: <strong>{util.parseDateTimeToString(recommendation.activityDto.start)}</strong><br/>
                    Activity end date: <strong>{util.parseDateTimeToString(recommendation.activityDto.end)}</strong><br/>
                </div>
            </div>
        )
    }
}

export {RecommendationComponent}