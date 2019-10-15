import * as React from "react";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import {constants} from "../AppConstants";
import {dispatchRoutesByUser} from "../dispacher";
import {NotFoundPage} from "../NotFoundPage";

class App extends React.Component {
    render() {

        const loggedUser = JSON.parse(localStorage.getItem(constants.loggedUser));
        const pathAndComponent = dispatchRoutesByUser((loggedUser !== null) ? loggedUser.userRole : '');
        console.log(pathAndComponent.path)
        return (
            <div className={"container"}>
                <div className={""}>
                    <Router>
                        <Switch>
                            <Route path={pathAndComponent.path} component={pathAndComponent.component}/>
                            <Route component={NotFoundPage}/>
                        </Switch>
                    </Router>
                </div>
            </div>
        )
    }
}

export { App };