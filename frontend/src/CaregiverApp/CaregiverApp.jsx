import React from 'react'
import {NavBar} from "../NavBar";

class CaregiverApp extends React.Component {
    render() {
        return (
            <div>
                <NavBar/>

                <div className={"jumbotron"}>
                    Caregiver
                </div>
            </div>
        )
    }
}

export {CaregiverApp}