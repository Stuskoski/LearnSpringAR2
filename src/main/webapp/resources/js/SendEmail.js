/**
 * Grabs all the email settings
 * and msg body and sends to the email
 * controller to be processed and
 * sent to the appropriate addresses
 */
function sendEmail() {
    var toEmail = document.getElementById("toEmail").value;
    var fromEmail = document.getElementById("fromEmail").value;
    var subject = document.getElementById("subject").value;
    var message = document.getElementById("message").value;

    var xhttp = new XMLHttpRequest();

    xhttp.open("POST", "/email/sendEmail", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");


    xhttp.send("toEmail=" + toEmail + "&fromEmail=" + fromEmail + "&subject=" + subject +
        "&message=" + message);


    xhttp.onreadystatechange = emailCheck;

    //On success disable the commit link again. On error show error box.
    function emailCheck() {
        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
                showAndThenHideInfoWindow(xhttp.responseText);
            } else {
                showAndThenHideInfoWindow(xhttp.responseText);
            }
        }
    }
}