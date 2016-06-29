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


    xhttp.onreadystatechange = settingsChangedSuccessfully;

    //On success disable the commit link again. On error show error box.
    function settingsChangedSuccessfully() {
        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
                alert("Email sent successfully");
            } else {
                alert("Unable to send email.  Make sure settings are correct.");
            }
        }
    }
}