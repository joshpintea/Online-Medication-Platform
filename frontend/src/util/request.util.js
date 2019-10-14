

export function handleResponse(response) {
    return response.text().then(text => {
        const data = text && JSON.parse(text);
        if (!response.ok) {
            const error = (data && data.error_description)
                                || (data && data.error) || data.message;
            return Promise.reject(error);
        }

        return data;
    });
}