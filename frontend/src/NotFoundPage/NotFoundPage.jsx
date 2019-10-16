
import React from 'react';
import {constants} from "../AppConstants";
import {dispatchRoutesByUser} from "../dispacher";

class NotFoundPage extends React.Component {
    render() {
        const user = JSON.parse(localStorage.getItem(constants.loggedUser));

        const pathAndComponent = dispatchRoutesByUser((user !== null) ? user.userRole : '' );

        return (
            <div className="container justify-content-center vertical-center">
                <div className="row">
                    <div className="col-md-12">
                        <div className="error-template">
                            <h1>
                                Oops!</h1>
                            <h2>
                                404 Not Found</h2>
                            <div className="error-details">
                                Sorry, an error has occured, Requested page not found!
                            </div>
                            <div className="error-actions">
                                <a href={pathAndComponent.path} className="btn btn-primary btn-lg"><span
                                    className="glyphicon glyphicon-home"></span>
                                    Take Me Home </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export {NotFoundPage};