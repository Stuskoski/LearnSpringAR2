/**
 * Gets the file in the file input area
 * and sends to the appropriate page/controller
 * to be uploaded into the database
 */
function uploadCustomerFile(){
    enableAnimation();

    var file = document.forms['customerFileForm']['customerFile'].files[0];
    var fd = new FormData();
    fd.append( 'file', file );

    $.ajax({
        url: '/uploadCustomerViaFile',
        data: fd,
        processData: false,
        contentType: false,
        type: 'POST',
        mimeType: 'multipart/form-data',

        success: function(data){
            disableAnimation();
            document.getElementById("loginErrorMsg").innerHTML = data;
        },
        error: function(data){
            disableAnimation();
            document.getElementById("loginErrorMsg").innerHTML = data;
        }
    });


}


/**
 * Grabs all the parameters from
 * the customer web form and sends
 * as a POST form to the appropriate
 * url.
 *
 * Handles success and failure with
 * msg displays
 */
function uploadCustomerViaWebForm() {
    if(isFormFilled()){
        var fd = new FormData();

        fd.append( 'firstName', document.getElementById("firstName").value);
        fd.append( 'lastName', document.getElementById("lastName").value );
        fd.append( 'emailAddress', document.getElementById("emailAddress").value );
        fd.append( 'homeAddress', document.getElementById("homeAddress").value );
        fd.append( 'city', document.getElementById("city").value );
        fd.append( 'state', document.getElementById("state").value );
        fd.append( 'zipCode', document.getElementById("zipCode").value );

        $.ajax({
            url: '/customer/add',
            data: fd,
            processData: false,
            contentType: false,
            type: 'POST',
            mimeType: 'multipart/form-data',

            success: function(data){
                disableAnimation();
                showAndThenHideInfoWindow(data);
                document.getElementById("webFormMsg").innerHTML = data;
            },
            error: function(data){
                disableAnimation();
                showAndThenHideInfoWindow(data);
                document.getElementById("webFormMsg").innerHTML = data;
            }
        });
    }


}

