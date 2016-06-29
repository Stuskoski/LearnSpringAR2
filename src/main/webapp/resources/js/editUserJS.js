
/**
 * Sent the id of the disabled link
 * Enables the link of user edit by
 * removing the css class
 *
 * @param id - Customer ID
 */
function enableLink(id){
    $('#commitLink'+id).removeClass("disabledAnchor");
}


/**
 * Function that receives the id of the
 * customer and sends a background
 * request to delete the customer.
 *
 * Hides the entire row in the process
 *
 * @param id - Customer ID
 */
function deleteCustomer(id){
    var xhttp = new XMLHttpRequest();
    /*xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("demo").innerHTML = xhttp.responseText;
        }
    };*/
    xhttp.open("POST", "/remove/"+id, true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();

    xhttp.onreadystatechange = customerDeletedSuccessfully;

    //On success disable the commit link again. On error show error box.
    function customerDeletedSuccessfully(){
        if (xhttp.readyState == 4 ) {
            if(xhttp.status == 200){
                $('#customerRow'+id).hide(500);
            }else{
                alert("Unable to delete customer")
            }
        }
    }
}

/**
 * Receives the customers id from a link
 * click and then pulls all the customers
 * info from their table row.
 *
 * Send the info to a add customer controller
 * that also handles if the customer's id exists.
 *
 * If the customer's id exists, which it should if
 * the user is editing the entry, the user is updated.
 *
 * Listener is also added to make the commit edit
 * link disabled again once the user's changes
 * have been confirmed.
 *
 * @param id - Customer ID
 */
function editCustomer(id){
    var firstName = document.getElementById("customerEntityFirstName"+id).textContent;
    var lastName = document.getElementById("customerEntityLastName"+id).textContent;
    var emailAddress = document.getElementById("customerEntityEmailAddress"+id).textContent;
    var homeAddress = document.getElementById("customerEntityHomeAddress"+id).textContent;
    var city = document.getElementById("customerEntityCity"+id).textContent;
    var state = document.getElementById("customerEntityState"+id).textContent;
    var zipCode = document.getElementById("customerEntityZipCode"+id).textContent;
    var timeStamp = document.getElementById("customerEntityTimeStamp"+id).textContent;


    /**
     * I believe the jquery plugin at the bottom
     * is adding white space and new lines in the
     * fields for whatever reason.
     *
     * This function removes the whitespace in the front
     * and back of the lines as well as the new line
     * characters which won't be needed.
     *
     * @type {string}
     */
    firstName = firstName.trim().replace(/(\r\n|\n|\r)/gm,"");
    lastName = lastName.trim().replace(/(\r\n|\n|\r)/gm,"");
    emailAddress = emailAddress.trim().replace(/(\r\n|\n|\r)/gm,"");
    homeAddress = homeAddress.trim().replace(/(\r\n|\n|\r)/gm,"");
    city = city.trim().replace(/(\r\n|\n|\r)/gm,"");
    state = state.trim().replace(/(\r\n|\n|\r)/gm,"");
    zipCode = zipCode.trim().replace(/(\r\n|\n|\r)/gm,"");
    timeStamp = timeStamp.trim().replace(/(\r\n|\n|\r)/gm,"");

    var xhttp = new XMLHttpRequest();

    xhttp.open("POST", "/customer/add", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    if(timeStamp==""){
        xhttp.send("id="+id+"&firstName="+firstName+"&lastName="+lastName+"&emailAddress="+emailAddress+"&homeAddress="+
            homeAddress+"&city="+city+"&state="+state+"&zipCode="+zipCode);
    }else{
        xhttp.send("id="+id+"&firstName="+firstName+"&lastName="+lastName+"&emailAddress="+emailAddress+"&homeAddress="+
            homeAddress+"&city="+city+"&state="+state+"&zipCode="+zipCode+"&timeStamp="+timeStamp);
    }

    xhttp.onreadystatechange = customerAddedSuccessfully;

    //On success disable the commit link again. On error show error box.
    function customerAddedSuccessfully(){
        if (xhttp.readyState == 4 ) {
            if(xhttp.status == 200){
                $('#commitLink'+id).addClass("disabledAnchor");
                var goodCommit = $("#customerRow"+id);

                goodCommit.removeClass("highLightRed");
                goodCommit.removeClass("highLightGreen");

                goodCommit.addClass("highLightGreen");
                goodCommit.fadeOut(500).fadeIn(500);
            }else{
                alert("Unable to commit customer changes");
                var badCommit = $("#customerRow"+id);

                badCommit.removeClass("highLightRed");
                badCommit.removeClass("highLightGreen");

                badCommit.addClass("highLightRed");
                badCommit.fadeOut(500).fadeIn(500);
            }
        }
    }
}


function alertMe(){
/*<script>*/
    function myFunction() {
        var x;
        if (confirm("Is this secure?") == true) {
            alert("lies!");
        } else {
            alert("correct!");
        }
    }
/*    </script>*/
}

//Turn the table into a sortable data table with jquery
$(document).ready(function() {
    $('#customerTable').DataTable();
} );

