"use strict";

$(document).ready(() => {
    $("#startQuiz").click(startQuiz);
});

function startQuiz() {
    $.ajax({
        type: "POST",
        url: "private",
        data: {'action' : 'generateQuiz'},
        dataType: "JSON",
        success: function(result) {
            alert(result);
        },
        error: function (e) {
            alert(this.url);
        }
    });
}