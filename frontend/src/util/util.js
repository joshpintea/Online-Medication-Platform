

export const util = {
    objectIsEmpty,
    parseDateToString,
    leftPad,
    parseDateTimeToString
};

function objectIsEmpty(obj) {
    for(var prop in obj) {
        if(obj.hasOwnProperty(prop)) {
            return false;
        }
    }

    return JSON.stringify(obj) === JSON.stringify({});
}


function parseDateToString(timestamp) {
    const date = new Date(timestamp);
    return date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
}

function parseDateTimeToString(timestamp) {
    const date = new Date(timestamp);
    return date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + "   "
                + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
}

function leftPad(num, size) {
    let s = num + "";
    while (s.length < size) s = "0" + s;
    return s;
}