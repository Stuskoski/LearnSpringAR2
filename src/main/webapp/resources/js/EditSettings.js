function editSettings() {
    if(isFormFilled()){
        var databaseURL = document.getElementById("databaseURL").value;
        var rootDatabaseURL = document.getElementById("rootDatabaseURL").value;
        var databaseUser = document.getElementById("databaseUser").value;
        var databasePass = document.getElementById("databasePass").value;
        var mailHost = document.getElementById("mailHost").value; //.textcontent
        var mailFrom = document.getElementById("mailFrom").value; //.textcontent

        var xhttp = new XMLHttpRequest();

        xhttp.open("POST", "/settings/changeSettings", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");


        xhttp.send("databaseURL=" + databaseURL + "&rootDatabaseURL=" + rootDatabaseURL + "&databaseUser=" + databaseUser +
            "&databasePass=" + databasePass + "&mailHost=" + mailHost + "&mailFrom=" + mailFrom);


        xhttp.onreadystatechange = settingsChangedSuccessfully;

        //On success disable the commit link again. On error show error box.
        function settingsChangedSuccessfully() {
            if (xhttp.readyState == 4) {
                if (xhttp.status == 200) {
                    showAndThenHideInfoWindow("Settings updated successfully");
                    document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
                    //alert("Settings changed successfully");
                } else {
                    showAndThenHideInfoWindow("Unable to change settings");
                    //alert("Unable to change settings.");
                }
            }
        }
    }

}
