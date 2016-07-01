/**
 * All functions that will use ajax
 * calls to call the pages that will
 * either create, clear or delete
 * the database
 */

/*--------------------- Create DB -----------------------*/
function callCreateDBPage(){
    var xhttp = new XMLHttpRequest();

    $('#homeScreenLoader').empty();

    xhttp.open("GET", "/modifyDB/createDB", true);
    //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedPage;

    //On success disable the commit link again. On error show error box.
    function receivedPage(){
        if (xhttp.readyState == 4 ) {
            if(xhttp.status == 200){
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
                showAndThenHideInfoWindow("Database created successfully");
            }else{
                document.getElementById("homeScreenLoader").innerHTML = "Unable to create database";
                showAndThenHideInfoWindow("Unable to create database");
            }
        }
    }
}
/*--------------------- Clear DB -----------------------*/
function callClearDBPage(){
    var xhttp = new XMLHttpRequest();

    $('#homeScreenLoader').empty();

    xhttp.open("GET", "/modifyDB/clearDB", true);
    //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedPage;

    //On success disable the commit link again. On error show error box.
    function receivedPage(){
        if (xhttp.readyState == 4 ) {
            if(xhttp.status == 200){
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
                showAndThenHideInfoWindow("Database cleared successfully");
            }else{
                document.getElementById("homeScreenLoader").innerHTML = "Unable to clear database";
                showAndThenHideInfoWindow("Unable to clear database");
            }
        }
    }
}
/*--------------------- Delete DB -----------------------*/
function callDeleteDBPage(){
    var xhttp = new XMLHttpRequest();

    $('#homeScreenLoader').empty();

    xhttp.open("GET", "/modifyDB/deleteDB", true);
    //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedPage;

    //On success disable the commit link again. On error show error box.
    function receivedPage(){
        if (xhttp.readyState == 4 ) {
            if(xhttp.status == 200){
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
                showAndThenHideInfoWindow("Database deleted successfully");
            }else{
                document.getElementById("homeScreenLoader").innerHTML = "Unable to delete database";
                showAndThenHideInfoWindow("Unable to delete database");
            }
        }
    }
}