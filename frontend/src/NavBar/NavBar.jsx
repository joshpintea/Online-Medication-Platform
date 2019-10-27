import React from 'react'
import {Link} from "react-router-dom";
import {constants} from "../AppConstants";

class NavBar extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            user: {}
        };
        this.handleClick = this.handleClick.bind(this);
    }

    componentDidMount() {
        const user = JSON.parse(localStorage.getItem(constants.loggedUser));
        this.setState({user: user});
    }

    handleClick(e) {
        localStorage.clear();
        window.location.href = constants.routes.app.login;
        e.preventDefault();
    }

    getLinks() {

    }

    render() {
        const {user} = this.state;

        return (
            <nav className="navbar navbar-expand-lg navbar-light bg-light font-size-22">
                <a className="navbar-brand" href="#">Assignment1</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                        aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul className="navbar-nav mr-auto">
                        {this.getLinks()}
                        <li className="nav-item">
                            <Link onClick={this.handleClick} to={"#"} className={"nav-link"}>Logout</Link>
                        </li>
                    </ul>

                    {user.name &&
                         <ul className={"navbar-nav"}>
                            <li className={"nav-item float-right"}>
                                Hello {user.name}
                            </li>
                        </ul>
                    }
                </div>
            </nav>
        );
    }
}

export {NavBar};