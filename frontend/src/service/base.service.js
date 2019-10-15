import {authHeader, handleResponse} from "../util";

export const baseService = {
    getMethod,
    deleteMethod,
    postMethod
};

function getMethod(url) {
    const requestOptions = {
        method: 'GET',
        headers: authHeader()
    };

    return fetch(url, requestOptions).then(handleResponse);
}

function deleteMethod(url, id) {
    let headers = authHeader();

    Object.assign(headers, {
        'Content-Type': 'application/html'
    });

    const requestOptions = {
        method:'DELETE',
        headers: authHeader()
    };

    return fetch(url + "/" + id, requestOptions).then(handleResponse);
}

function postMethod(url, obj) {
    const headers = authHeader();

    Object.assign(headers, {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    });

    const requestOptions = {
        method: "POST",
        headers: headers,
        body: JSON.stringify(obj)
    };

    return fetch(url, requestOptions).then(handleResponse);
}