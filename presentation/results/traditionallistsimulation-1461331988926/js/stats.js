var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "6000",
        "ok": "6000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "203",
        "ok": "203",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "7395",
        "ok": "7395",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "2438",
        "ok": "2438",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "2134",
        "ok": "2134",
        "ko": "-"
    },
    "percentiles1": {
        "total": "2040",
        "ok": "2040",
        "ko": "-"
    },
    "percentiles2": {
        "total": "4172",
        "ok": "4172",
        "ko": "-"
    },
    "percentiles3": {
        "total": "6350",
        "ok": "6350",
        "ko": "-"
    },
    "percentiles4": {
        "total": "7127",
        "ok": "7127",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 2439,
        "percentage": 41
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 324,
        "percentage": 5
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 3237,
        "percentage": 54
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "19.737",
        "ok": "19.737",
        "ko": "-"
    }
},
contents: {
"req_traditionallist-358b1": {
        type: "REQUEST",
        name: "traditionalList",
path: "traditionalList",
pathFormatted: "req_traditionallist-358b1",
stats: {
    "name": "traditionalList",
    "numberOfRequests": {
        "total": "6000",
        "ok": "6000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "203",
        "ok": "203",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "7395",
        "ok": "7395",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "2438",
        "ok": "2438",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "2134",
        "ok": "2134",
        "ko": "-"
    },
    "percentiles1": {
        "total": "2040",
        "ok": "2040",
        "ko": "-"
    },
    "percentiles2": {
        "total": "4172",
        "ok": "4172",
        "ko": "-"
    },
    "percentiles3": {
        "total": "6350",
        "ok": "6350",
        "ko": "-"
    },
    "percentiles4": {
        "total": "7127",
        "ok": "7127",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 2439,
        "percentage": 41
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 324,
        "percentage": 5
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 3237,
        "percentage": 54
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "19.737",
        "ok": "19.737",
        "ko": "-"
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
