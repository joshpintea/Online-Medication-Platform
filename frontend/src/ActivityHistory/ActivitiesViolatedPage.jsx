import React from 'react';
import {patientService} from "../service";
import {ActivitiesAfterPatientForm} from "./form";
import {ActivityViolated} from "./component";
import './index.css';

class ActivitiesViolatedPage extends React.Component {
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

        const activitiesViolated = activities.filter( activity => activity.violated === true);

        const activitiesViolatedContent = activities.map((activity, key) => {
            return (
                <ActivityViolated activity={activity} key={key}/>
            )
        });

        return (
            <div>
                <div className={"jumbotron"}>
                    <ActivitiesAfterPatientForm patients={patients} callback={this.setActivities}/>
                    <div className={"grid-container"}>
                        {activitiesViolatedContent}
                    </div>
                </div>
            </div>
        );
    }
}


export {ActivitiesViolatedPage};