var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1000",
        "ok": "992",
        "ko": "8"
    },
    "minResponseTime": {
        "total": "3455",
        "ok": "3455",
        "ko": "6729"
    },
    "maxResponseTime": {
        "total": "48790",
        "ok": "48790",
        "ko": "9619"
    },
    "meanResponseTime": {
        "total": "28208",
        "ok": "28368",
        "ko": "8388"
    },
    "standardDeviation": {
        "total": "12893",
        "ok": "12820",
        "ko": "762"
    },
    "percentiles1": {
        "total": "28507",
        "ok": "28591",
        "ko": "8384"
    },
    "percentiles2": {
        "total": "39080",
        "ok": "39173",
        "ko": "8777"
    },
    "percentiles3": {
        "total": "48511",
        "ok": "48512",
        "ko": "9325"
    },
    "percentiles4": {
        "total": "48755",
        "ok": "48755",
        "ko": "9560"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 992,
        "percentage": 99
    },
    "group4": {
        "name": "failed",
        "count": 8,
        "percentage": 1
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "20.408",
        "ok": "20.245",
        "ko": "0.163"
    }
},
contents: {
"req_reactivelist-f9a12": {
        type: "REQUEST",
        name: "reactiveList",
path: "reactiveList",
pathFormatted: "req_reactivelist-f9a12",
stats: {
    "name": "reactiveList",
    "numberOfRequests": {
        "total": "1000",
        "ok": "992",
        "ko": "8"
    },
    "minResponseTime": {
        "total": "3455",
        "ok": "3455",
        "ko": "6729"
    },
    "maxResponseTime": {
        "total": "48790",
        "ok": "48790",
        "ko": "9619"
    },
    "meanResponseTime": {
        "total": "28208",
        "ok": "28368",
        "ko": "8388"
    },
    "standardDeviation": {
        "total": "12893",
        "ok": "12820",
        "ko": "762"
    },
    "percentiles1": {
        "total": "28507",
        "ok": "28591",
        "ko": "8384"
    },
    "percentiles2": {
        "total": "39080",
        "ok": "39173",
        "ko": "8777"
    },
    "percentiles3": {
        "total": "48511",
        "ok": "48512",
        "ko": "9325"
    },
    "percentiles4": {
        "total": "48755",
        "ok": "48755",
        "ko": "9560"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 992,
        "percentage": 99
    },
    "group4": {
        "name": "failed",
        "count": 8,
        "percentage": 1
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "20.408",
        "ok": "20.245",
        "ko": "0.163"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
