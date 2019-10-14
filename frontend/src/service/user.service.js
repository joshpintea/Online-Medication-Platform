import {constants} from "../AppConstants";
import {authHeader, handleResponse} from "../util";


export const userService = {
    login,
    getLoggedUser
};

function login(username, password) {
    const requestOptions = {
        method: 'POST',
        url: constants.routes.api.loginUrl,
        headers: new Headers({
            'Authorization': 'Basic Y2xpZW50SWQ6c2VjcmV0',
            'Content-Type': 'application/x-www-form-urlencoded'
        }),
        body: "grant_type=password&username=" + username + "&password=" + password + "&client_id=clientId"
    };

    return fetch(requestOptions.url, requestOptions)
        .then(handleResponse)
        .then(
            tokenData => {
                localStorage.clear();
                localStorage.setItem(constants.savedToken, JSON
                    .stringify({
                        authData: "Bearer " + tokenData.access_token
                    }));
                return getLoggedUser();
            }
        );
}

function getLoggedUser() {

    const requestOptions = {
        method: 'GET',
        headers: authHeader()
    };

    return fetch(constants.routes.api.loggedUserUrl, requestOptions).then(handleResponse);

}