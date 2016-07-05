/**
 * Shows and then hides the display
 * window with the passed message.
 *
 * Takes 3 seconds
 *
 * @param msg Alert message to be shown
 */
function showAndThenHideInfoWindow(msg){
    var popupWindow = $("#infoPopupWindowBorder");

    document.getElementById("infoPopupMsg").innerHTML = msg;
    popupWindow.removeClass("hideMe");
    popupWindow.fadeIn("slow");
    setTimeout(hideInfoWindow, 2000);
}

function hideInfoWindow(){
    $("#infoPopupWindowBorder").fadeOut("slow");
}
