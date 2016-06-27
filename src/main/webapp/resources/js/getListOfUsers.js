/**
 * Created by r730819 on 6/27/2016.
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