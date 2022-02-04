"use strict";

$(document).ready(() => {
    $("#helloButton").click(helloButton);
});

function helloButton() {
    let output = "Hello! Welcome to MathWiz " + $("#nameInput").val();
    
    $("#output").html(output);
    clearForm();
}

function clearForm() {
    $("#nameInput").val('');
}