import {NavBar} from "./NavBar";
import React from "react";
import {constants} from "../AppConstants";

class CaregiverNavBar extends NavBar {


    getLinks() {
        return (
            <li>
                <a href={constants.routes.app.activitiesViolated} className={"nav-link"}>Activities</a>
            </li>
        )
    }
}

export {CaregiverNavBar};