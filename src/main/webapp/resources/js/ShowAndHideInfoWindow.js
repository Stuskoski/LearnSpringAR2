//Starts the animation for 3 seconds and then fades
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
