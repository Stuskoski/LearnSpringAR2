
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
                showAndThenHideInfoWindow("Unable to delete customer");
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

    if(checkFirstNameEdit(id) && checkLastNameEdit(id) && checkEmailEdit(id) && checkHomeEdit(id) && checkCityEdit(id)
        && checkStateEdit(id) && checkZipCodeEdit(id)) {


        var firstName = document.getElementById("customerEntityFirstName" + id).textContent;
        var lastName = document.getElementById("customerEntityLastName" + id).textContent;
        var emailAddress = document.getElementById("customerEntityEmailAddress" + id).textContent;
        var homeAddress = document.getElementById("customerEntityHomeAddress" + id).textContent;
        var city = document.getElementById("customerEntityCity" + id).textContent;
        var state = document.getElementById("customerEntityState" + id).textContent;
        var zipCode = document.getElementById("customerEntityZipCode" + id).textContent;
        var timeStamp = document.getElementById("customerEntityTimeStamp" + id).textContent;


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
        firstName = firstName.trim().replace(/(\r\n|\n|\r)/gm, "");
        lastName = lastName.trim().replace(/(\r\n|\n|\r)/gm, "");
        emailAddress = emailAddress.trim().replace(/(\r\n|\n|\r)/gm, "");
        homeAddress = homeAddress.trim().replace(/(\r\n|\n|\r)/gm, "");
        city = city.trim().replace(/(\r\n|\n|\r)/gm, "");
        state = state.trim().replace(/(\r\n|\n|\r)/gm, "");
        zipCode = zipCode.trim().replace(/(\r\n|\n|\r)/gm, "");
        timeStamp = timeStamp.trim().replace(/(\r\n|\n|\r)/gm, "");

        var xhttp = new XMLHttpRequest();

        xhttp.open("POST", "/customer/add", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        if (timeStamp == "") {
            xhttp.send("id=" + id + "&firstName=" + firstName + "&lastName=" + lastName + "&emailAddress=" + emailAddress + "&homeAddress=" +
                homeAddress + "&city=" + city + "&state=" + state + "&zipCode=" + zipCode);
        } else {
            xhttp.send("id=" + id + "&firstName=" + firstName + "&lastName=" + lastName + "&emailAddress=" + emailAddress + "&homeAddress=" +
                homeAddress + "&city=" + city + "&state=" + state + "&zipCode=" + zipCode + "&timeStamp=" + timeStamp);
        }

        xhttp.onreadystatechange = customerAddedSuccessfully;

        //On success disable the commit link again. On error show error box.
        function customerAddedSuccessfully() {
            if (xhttp.readyState == 4) {
                if (xhttp.status == 200 && xhttp.responseText == 'Customer updated') {
                    $('#commitLink' + id).addClass("disabledAnchor");
                    var goodCommit = $("#customerRow" + id);

                    goodCommit.removeClass("highLightRed");
                    goodCommit.removeClass("highLightGreen");

                    goodCommit.addClass("highLightGreen");
                    goodCommit.fadeOut(500).fadeIn(500);
                } else {
                    showAndThenHideInfoWindow("Unable to commit customer changes");
                    var badCommit = $("#customerRow" + id);

                    badCommit.removeClass("highLightRed");
                    badCommit.removeClass("highLightGreen");

                    badCommit.addClass("highLightRed");
                    badCommit.fadeOut(500).fadeIn(500);
                }
            }
        }
    }else{
        showAndThenHideInfoWindow("Unable to commit customer changes");
        var badCommit = $("#customerRow" + id);

        badCommit.removeClass("highLightRed");
        badCommit.removeClass("highLightGreen");

        badCommit.addClass("highLightRed");
        badCommit.fadeOut(500).fadeIn(500);
    }
}


/**
 * Start the functions that will
 * verify editing of the table
 * is correct.
 *
 * If not throw msg and disable
 * link;
 *
 * @param id
 */

function checkFirstNameEdit(id){
    var first = document.getElementById("customerEntityFirstName"+id).textContent;
    first = first.trim().replace(/(\r\n|\n|\r)/gm,"");
    if(first.length > 30){
        showAndThenHideInfoWindow("First name must be 30 characters or less");
        $('#commitLink'+id).addClass("disabledAnchor");

        var badCommit = $("#customerEntityFirstName"+id);

        badCommit.removeClass("highLightRed");
        badCommit.removeClass("highLightGreen");

        badCommit.addClass("highLightRed");

        return false;
    }else{
        var goodCommit = $("#customerEntityFirstName"+id);

        goodCommit.removeClass("highLightRed");
        goodCommit.removeClass("highLightGreen");

        return true;
    }
}

function checkLastNameEdit(id){
    var last = document.getElementById("customerEntityLastName"+id).textContent;
    last = last.trim().replace(/(\r\n|\n|\r)/gm,"");
    if(last.length > 30){
        showAndThenHideInfoWindow("Last name must be 30 characters or less");
        $('#commitLink'+id).addClass("disabledAnchor");

        var badCommit = $("#customerEntityLastName"+id);

        badCommit.removeClass("highLightRed");
        badCommit.removeClass("highLightGreen");

        badCommit.addClass("highLightRed");

        return false;
    }else{
        var goodCommit = $("#customerEntityLastName"+id);

        goodCommit.removeClass("highLightRed");
        goodCommit.removeClass("highLightGreen");

        return true;
    }
}

function checkEmailEdit(id){
    var email = document.getElementById("customerEntityEmailAddress"+id).textContent;
    email = email.trim().replace(/(\r\n|\n|\r)/gm,"");
    if(email.length > 50){
        showAndThenHideInfoWindow("Email must be 50 characters or less");
        $('#commitLink'+id).addClass("disabledAnchor");

        var badCommit = $("#customerEntityEmailAddress"+id);

        badCommit.removeClass("highLightRed");
        badCommit.removeClass("highLightGreen");

        badCommit.addClass("highLightRed");

        return false;
    }else{
        var goodCommit = $("#customerEntityEmailAddress"+id);

        goodCommit.removeClass("highLightRed");
        goodCommit.removeClass("highLightGreen");

        return true;
    }
}

function checkHomeEdit(id){
    var home = document.getElementById("customerEntityHomeAddress"+id).textContent;
    home = home.trim().replace(/(\r\n|\n|\r)/gm,"");
    if(home.length > 60){
        showAndThenHideInfoWindow("Home address must be 60 characters or less");
        $('#commitLink'+id).addClass("disabledAnchor");

        var badCommit = $("#customerEntityHomeAddress"+id);

        badCommit.removeClass("highLightRed");
        badCommit.removeClass("highLightGreen");

        badCommit.addClass("highLightRed");

        return false;

    }else{
        var goodCommit = $("#customerEntityHomeAddress"+id);

        goodCommit.removeClass("highLightRed");
        goodCommit.removeClass("highLightGreen");

        return true;
    }
}

function checkCityEdit(id){
    var city = document.getElementById("customerEntityCity"+id).textContent;
    city = city.trim().replace(/(\r\n|\n|\r)/gm,"");
    if(city.length > 40){
        showAndThenHideInfoWindow("City must be 40 characters or less");
        $('#commitLink'+id).addClass("disabledAnchor");

        var badCommit = $("#customerEntityCity"+id);

        badCommit.removeClass("highLightRed");
        badCommit.removeClass("highLightGreen");

        badCommit.addClass("highLightRed");

        return false;
    }else{
        var goodCommit = $("#customerEntityCity"+id);

        goodCommit.removeClass("highLightRed");
        goodCommit.removeClass("highLightGreen");

        return true;
    }
}

function checkStateEdit(id){
    var state = document.getElementById("customerEntityState"+id).textContent;
    state = state.trim().replace(/(\r\n|\n|\r)/gm,"");
    if(state.length != 2){
        showAndThenHideInfoWindow("State must be 2 characters long");
        $('#commitLink'+id).addClass("disabledAnchor");

        var badCommit = $("#customerEntityState"+id);

        badCommit.removeClass("highLightRed");
        badCommit.removeClass("highLightGreen");

        badCommit.addClass("highLightRed");

        return false;
    }else{
        var goodCommit = $("#customerEntityState"+id);

        goodCommit.removeClass("highLightRed");
        goodCommit.removeClass("highLightGreen");

        return true;
    }
}

function checkZipCodeEdit(id){
    var zipCode = document.getElementById("customerEntityZipCode"+id).textContent;
    zipCode = zipCode.trim().replace(/(\r\n|\n|\r)/gm,"");
    if(zipCode.length > 15){
        showAndThenHideInfoWindow("Zip code must be less than 15 characters");
        $('#commitLink'+id).addClass("disabledAnchor");

        var badCommit = $("#customerEntityZipCode"+id);

        badCommit.removeClass("highLightRed");
        badCommit.removeClass("highLightGreen");

        badCommit.addClass("highLightRed");

        return false;
    }else{
        var goodCommit = $("#customerEntityZipCode"+id);

        goodCommit.removeClass("highLightRed");
        goodCommit.removeClass("highLightGreen");

        return true;
    }
}


/**
 * Activate the jquery for the table
 */
function makeViewCustomersIntoDataTable(){
    $('#customerTable').DataTable();
}



