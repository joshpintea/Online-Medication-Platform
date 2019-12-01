import React from 'react';
import {patientService} from "../service";
import {ActivitiesAfterPatientForm} from "./form";
import {ActivityBarChart} from "./chart";

class ActivityHistoryPage extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            patients: [],
            activities: []
        };

        this.setActivities = this.setActivities.bind(this);
    }

    componentDidMount() {
        patientService.getAll().then(
            patients => {
                this.setState({patients: patients});
            }
        )
    }

    setActivities(activities) {
        this.setState({activities: activities});
    }

    render() {
        const {patients, activities} = this.state;

        return (
            <div>
                <div className={"jumbotron"}>
                    <ActivitiesAfterPatientForm patients={patients} callback={this.setActivities}/>
                    <ActivityBarChart activities={activities}/>
                </div>
            </div>
        );
    }
}

export {ActivityHistoryPage}
