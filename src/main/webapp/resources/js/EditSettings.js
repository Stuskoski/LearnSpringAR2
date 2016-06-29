function editSettings() {
    var databaseURL = document.getElementById("databaseURL").value;
    var rootDatabaseURL = document.getElementById("rootDatabaseURL").value;
    var databaseUser = document.getElementById("databaseUser").value;
    var databasePass = document.getElementById("databasePass").value;
    var mailHost = document.getElementById("mailHost").value; //.textcontent

    var xhttp = new XMLHttpRequest();

    xhttp.open("POST", "/settings/changeSettings", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");


    xhttp.send("databaseURL=" + databaseURL + "&rootDatabaseURL=" + rootDatabaseURL + "&databaseUser=" + databaseUser +
        "&databasePass=" + databasePass + "&mailHost=" + mailHost);


    xhttp.onreadystatechange = settingsChangedSuccessfully;

    //On success disable the commit link again. On error show error box.
    function settingsChangedSuccessfully() {
        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
                alert("Settings changed successfully");
            } else {
                alert("Unable to change settings.");
            }
        }
    }
}
