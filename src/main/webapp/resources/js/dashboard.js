/*------------------------ Side Navbar Customization ------------------------*/
$('#sidebar').affix({
    offset: {
        top: $('header').height()
    }
});

//sets the custom css for the side nav bar links
function setLinkActive(idName){

    $('#side-nav-bar-stats').removeClass("custom-active-nav-link");
    $('#side-nav-bar-database').removeClass("custom-active-nav-link");
    $('#side-nav-bar-upload-customers').removeClass("custom-active-nav-link");
    $('#side-nav-bar-information').removeClass("custom-active-nav-link");
    $('#side-nav-bar-settings').removeClass("custom-active-nav-link");

    $('#'+idName).addClass("custom-active-nav-link");
}

/*------------------------ Settings Links ----------------------------*/
function pullSettingsPage(){
    enableAnimation();
    var xhttp = new XMLHttpRequest();
    var xhttps = new

    $('#homeScreenLoader').empty();

    xhttp.open("GET", "/settings", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedPage;

    //On success disable the commit link again. On error show error box.
    function receivedPage(){
        if (xhttp.readyState == 4 ) {
            disableAnimation();
            if(xhttp.status == 200){
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
            }else{
                document.getElementById("homeScreenLoader").innerHTML = "Unable to pull settings page";
            }
        }
    }
}





/*------------------------ Information Links ----------------------------*/
/**
 * Choose to show or hide the extra
 * links under information category
 */
function showInformationOptions(){
    var infoLink = $('#informationLinks');
    if(infoLink.hasClass("hideMe")){
        infoLink.fadeIn(300).removeClass("hideMe");
    }else{
        infoLink.fadeOut(300).addClass("hideMe");
    }
}

function pullLoggingPage(){
    enableAnimation();
    var xhttp = new XMLHttpRequest();

    $('#homeScreenLoader').empty();

    xhttp.open("GET", "/logging", true);
    //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedPage;

    //On success disable the commit link again. On error show error box.
    function receivedPage(){
        if (xhttp.readyState == 4 ) {
            disableAnimation();
            if(xhttp.status == 200){
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
            }else{
                document.getElementById("homeScreenLoader").innerHTML = "Unable to retrieve logging page";
            }
        }
    }
}

/*------------------------ Email Links ----------------------------*/
function pullEmailPage(){
    enableAnimation();

    var xhttp = new XMLHttpRequest();

    $('#homeScreenLoader').empty();

    xhttp.open("GET", "/email", true);
    //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedPage;

    //On success disable the commit link again. On error show error box.
    function receivedPage(){
        if (xhttp.readyState == 4 ) {
            disableAnimation();
            if(xhttp.status == 200){
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
            }else{
                document.getElementById("homeScreenLoader").innerHTML = "Unable to pull email page";
            }
        }
    }
}
/*------------------------ Database Links ----------------------------*/
function showDatabaseOptions(){
    var infoLink = $('#databaseLinks');
    if(infoLink.hasClass("hideMe")){
        infoLink.fadeIn(300).removeClass("hideMe");
    }else{
        infoLink.fadeOut(300).addClass("hideMe");
    }
}

function pullModifyDatabasePage(){
    enableAnimation();

    var xhttp = new XMLHttpRequest();

    $('#homeScreenLoader').empty();

    xhttp.open("GET", "/modifyDB", true);
    //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedPage;

    //On success disable the commit link again. On error show error box.
    function receivedPage(){
        if (xhttp.readyState == 4 ) {
            disableAnimation();
            if(xhttp.status == 200){
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
            }else{
                document.getElementById("homeScreenLoader").innerHTML = "Unable to pull modify database page";
            }
        }
    }
}

function pullViewCustomersPage(){
    enableAnimation();
    var xhttp = new XMLHttpRequest();

    $('#homeScreenLoader').empty();

    xhttp.open("GET", "/customers", true);
    //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedPage;

    //On success disable the commit link again. On error show error box.
    function receivedPage(){
        if (xhttp.readyState == 4 ) {
            disableAnimation();
            if(xhttp.status == 200){
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
                makeViewCustomersIntoDataTable();
            }else{
                document.getElementById("homeScreenLoader").innerHTML = "Unable to pull customers page";
            }
        }
    }
}

/*------------------------ Upload Customer Links ----------------------------*/

function showCustomerOptions(){
    var infoLink = $('#customerLinks');
    if(infoLink.hasClass("hideMe")){
        infoLink.fadeIn(300).removeClass("hideMe");
    }else{
        infoLink.fadeOut(300).addClass("hideMe");
    }
}



function pullUploadTextFilePage(){
    enableAnimation();

    var xhttp = new XMLHttpRequest();

    $('#homeScreenLoader').empty();

    xhttp.open("GET", "/uploadCustomers/textFileUpload", true);
    //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedPage;

    //On success disable the commit link again. On error show error box.
    function receivedPage(){
        if (xhttp.readyState == 4 ) {
            disableAnimation();
            if(xhttp.status == 200){
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
            }else{
                document.getElementById("homeScreenLoader").innerHTML = "Unable to pull customer text file page";
            }
        }
    }
}

function pullUploadWebFormPage(){
    enableAnimation();

    var xhttp = new XMLHttpRequest();

    $('#homeScreenLoader').empty();

    xhttp.open("GET", "/uploadCustomers/webFormUpload", true);
    //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedPage;

    //On success disable the commit link again. On error show error box.
    function receivedPage(){
        if (xhttp.readyState == 4 ) {
            disableAnimation();
            if(xhttp.status == 200){
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
            }else{
                document.getElementById("homeScreenLoader").innerHTML = "Unable to pull customer web form page";
            }
        }
    }
}

/*------------------------ Stats Links ----------------------------*/
function pullStatsPage(){
    enableAnimation();

    var xhttp = new XMLHttpRequest();

    $('#homeScreenLoader').empty();

    xhttp.open("GET", "/stats", true);
    //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedPage;

    //On success disable the commit link again. On error show error box.
    function receivedPage(){
        if (xhttp.readyState == 4 ) {
            disableAnimation();
            if(xhttp.status == 200){
                document.getElementById("homeScreenLoader").innerHTML = xhttp.responseText;
            }else{
                document.getElementById("homeScreenLoader").innerHTML = "Unable to pull stats page";
            }
        }
    }
}