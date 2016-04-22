var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1000",
        "ok": "944",
        "ko": "56"
    },
    "minResponseTime": {
        "total": "1167",
        "ok": "1167",
        "ko": "7091"
    },
    "maxResponseTime": {
        "total": "46363",
        "ok": "46363",
        "ko": "14663"
    },
    "meanResponseTime": {
        "total": "26155",
        "ok": "27043",
        "ko": "11189"
    },
    "standardDeviation": {
        "total": "13126",
        "ok": "12956",
        "ko": "3102"
    },
    "percentiles1": {
        "total": "25435",
        "ok": "26698",
        "ko": "8449"
    },
    "percentiles2": {
        "total": "38098",
        "ok": "39339",
        "ko": "14634"
    },
    "percentiles3": {
        "total": "46150",
        "ok": "46191",
        "ko": "14661"
    },
    "percentiles4": {
        "total": "46330",
        "ok": "46331",
        "ko": "14662"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 1,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 943,
        "percentage": 94
    },
    "group4": {
        "name": "failed",
        "count": 56,
        "percentage": 6
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "21.277",
        "ok": "20.085",
        "ko": "1.191"
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
        "total": "1000",
        "ok": "944",
        "ko": "56"
    },
    "minResponseTime": {
        "total": "1167",
        "ok": "1167",
        "ko": "7091"
    },
    "maxResponseTime": {
        "total": "46363",
        "ok": "46363",
        "ko": "14663"
    },
    "meanResponseTime": {
        "total": "26155",
        "ok": "27043",
        "ko": "11189"
    },
    "standardDeviation": {
        "total": "13126",
        "ok": "12956",
        "ko": "3102"
    },
    "percentiles1": {
        "total": "25435",
        "ok": "26698",
        "ko": "8449"
    },
    "percentiles2": {
        "total": "38098",
        "ok": "39339",
        "ko": "14634"
    },
    "percentiles3": {
        "total": "46150",
        "ok": "46191",
        "ko": "14661"
    },
    "percentiles4": {
        "total": "46330",
        "ok": "46331",
        "ko": "14662"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 1,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 943,
        "percentage": 94
    },
    "group4": {
        "name": "failed",
        "count": 56,
        "percentage": 6
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "21.277",
        "ok": "20.085",
        "ko": "1.191"
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
