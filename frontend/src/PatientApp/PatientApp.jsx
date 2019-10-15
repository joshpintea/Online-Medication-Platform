import React from 'react'
import {NavBar} from "../NavBar";

class PatientApp extends React.Component {


    render() {
        return (
            <div>
                <NavBar/>
                <div className="jumbotron">
                    Patient app
                </div>
            </div>
        )
    }
}

export {PatientApp}