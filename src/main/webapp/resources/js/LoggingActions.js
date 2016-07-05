/**
 * Grabs all the logs from
 * the logging page which
 * is handled with the logging
 * controller
 */
function refreshLogs() {
    $("#noticeContainer").html('Loading..');
    $.ajax({
        type: 'GET',
        url: 'logging/getLogs',
        timeout: 2000,
        success: function(data) {

            if(data == ""){
                $("#logContainer").html("No logs available");
            }else{
                $("#logContainer").html(data);
            }

            $("#noticeContainer").html('');
            window.setTimeout(update, 10000);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            $("#noticeContainer").html('Timeout contacting server..');
            window.setTimeout(update, 60000);
        }
    })
}

/**
 * Ajax call to delete all the logs and
 * set the content of the logs div to the
 * html data
 */
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