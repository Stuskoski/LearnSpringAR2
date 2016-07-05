/**
 * Functions for displaying and hiding
 * the loading HEB icon between screens
 * and during actions such as uploading
 * customer lists
 */

$(window).load(function() {
    $("#loadingAnimationBorder").fadeOut("slow");
});

//Starts the animation for 5 minutes
function enableAnimation(){
    $("#loadingAnimationBorder").fadeIn("slow");
    setTimeout(disableAnimation, 300000);
}

//disables the animation for the above function
function disableAnimation(){
    $("#loadingAnimationBorder").fadeOut("slow");
}