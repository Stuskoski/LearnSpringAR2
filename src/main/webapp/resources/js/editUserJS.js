
/*
Sent the id of the disabled link
Enables the link of user edit
 */
function enableLink(id){
    var idCon = "commitLink"+id;
    $('#'+idCon).removeClass("disabledAnchor");
}

function editCustomer(id){
    var firstName = document.getElementById("customerEntityFirstName"+id).textContent
    var lastName = document.getElementById("customerEntityFirstName"+id).textContent
    var emailAddress = document.getElementById("customerEntityFirstName"+id).textContent
    var homeAddress = document.getElementById("customerEntityFirstName"+id).textContent
    var city = document.getElementById("customerEntityFirstName"+id).textContent
    var state = document.getElementById("customerEntityFirstName"+id).textContent
    var zipCode = document.getElementById("customerEntityFirstName"+id).textContent


    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("demo").innerHTML = xhttp.responseText;
        }
    };
    xhttp.open("POST", "/customer/add", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("id="+id+"&firstName="+firstName+"&lastName="+lastName+"&emailAddress="+emailAddress+"&homeAddress="+
    homeAddress+"&city="+city+"&state="+state+"&zipCode="+zipCode);
}