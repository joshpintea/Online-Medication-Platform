import {pipelinePrimaryTopicReference} from "@babel/types";


export const util = {
    objectIsEmpty,
    parseDateToString,
    leftPad,
    parseDateTimeToString,
    utcTimeStampToLocalTimestamp
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


function utcTimeStampToLocalTimestamp(timestamp) {
    const date = new Date(timestamp);

    var offset = date.getTimezoneOffset();

    var localDate = new Date(timestamp);
    localDate.setTime(date.getTime() + (offset * 60 * 1000))

    console.log(timestamp, date, localDate);
    return date.getTime()
}