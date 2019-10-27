import React from 'react';
import {Client} from "@stomp/stompjs";
import {constants} from "../AppConstants";
import {ActivityComponent} from "./ActivityComponent";

class CaregiverNotificationPage extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            client: {},
            activitiesViolated: []
        }
    }

    componentDidMount() {
        // configure client

        const client = new Client();
        const caregiver = JSON.parse(localStorage.getItem(constants.loggedUser));
        // console.log(constants.routes.api.host)
        client.configure({
            brokerURL: 'ws://'+ constants.routes.api.host + ':' + constants.routes.api.port + '/app/stomp',
            onConnect: () => {
                client.subscribe("/activity/rule_violated/" + caregiver.id, response => {
                    const activity = JSON.parse(response.body);
                    let {activitiesViolated} = this.state;

                    activitiesViolated.push(activity);

                    this.setState({activitiesViolated: activitiesViolated});
                });
            }
        });

        client.activate();

    }

    componentWillUnmount() {
        const {client} = this.state;

        client.deactivate();

        this.setState({client: {}});
    }

    render() {
        const {activitiesViolated} = this.state;

        const activitiesContent = activitiesViolated.map((activity) => {
            return <ActivityComponent activity={activity}/>
        });

        return (
            <div className={"jumbotron"}>
                <h1>Activities</h1>
                {activitiesContent}
            </div>
        )
    }
}

export {CaregiverNotificationPage}