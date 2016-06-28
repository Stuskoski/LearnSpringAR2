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