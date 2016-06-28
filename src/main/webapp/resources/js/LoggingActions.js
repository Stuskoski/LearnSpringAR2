function refreshLogs() {
    $("#noticeContainer").html('Loading..');
    $.ajax({
        type: 'GET',
        url: 'logging/getLogs',
        timeout: 2000,
        success: function(data) {
            $("#logContainer").html(data);
            $("#noticeContainer").html('');
            window.setTimeout(update, 10000);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            $("#noticeContainer").html('Timeout contacting server..');
            window.setTimeout(update, 60000);
        }
    })
}

function clearLogs() {
    $("#noticeContainer").html('Clearing..');
    $.ajax({
        type: 'GET',
        url: 'logging/clearLogs',
        timeout: 2000,
        success: function(data) {
            $("#noticeContainer").html(data);
            $("#logContainer").html('');
            window.setTimeout(update, 10000);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            $("#noticeContainer").html('Timeout contacting server..');
            window.setTimeout(update, 60000);
        }
    })
}