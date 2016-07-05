/**
 * Ajax call to get the sorted customers
 * from the email/populateSortedCustomers.
 *
 * The controller will grab the call and
 * generate a response body that is put into
 * the text area
 */
function getSortedCustomers(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("demo").innerHTML = xhttp.responseText;
        }
    };
    xhttp.open("GET", "email/populateSortedCustomers", true);
    //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedCustomers;

    //On success disable the commit link again. On error show error box.
    function receivedCustomers(){
        if (xhttp.readyState == 4 ) {
            if(xhttp.status == 200){
                document.getElementById("message").value = xhttp.responseText;
            }else{
                document.getElementById("message").value = "Unable to retrieve sorted customer list";
            }
        }
    }
}

/**
 * Ajax call to get the unsorted customers
 * from the email/populateUnsortedCustomers.
 *
 * The controller will grab the call and
 * generate a response body that is put into
 * the text area
 */
function getUnsortedCustomers(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("demo").innerHTML = xhttp.responseText;
        }
    };
    xhttp.open("GET", "email/populateUnsortedCustomers", true);
    //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = receivedCustomers;

    //On success disable the commit link again. On error show error box.
    function receivedCustomers(){
        if (xhttp.readyState == 4 ) {
            if(xhttp.status == 200){
                document.getElementById("message").value = xhttp.responseText;
            }else{
                document.getElementById("message").value = "Unable to retrieve unsorted customer list";
            }
        }
    }
}