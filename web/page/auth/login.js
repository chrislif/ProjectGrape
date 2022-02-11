"use strict";

$(document).ready(() => {
    displayErrorList();
});

function displayErrorList() {
    var errorHTML = "<ul>";
    
    for (let i in errorJSON) {
        errorHTML += "<li><span style=\"color : red\">" + errorJSON[i] + "</span></li>";
    }
    
    errorHTML += "</ul>";
    
    $("#errorDisplay").html(errorHTML);
    
    if (errorJSON.length < 1) {
        $("#errorDisplay").hide();
    }
}
