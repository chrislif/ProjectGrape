"use strict";

$(document).ready(() => {
    $("#startQuiz").click(startQuiz);
});

function startQuiz() {
    $.ajax({
        type: "POST",
        url: "private",
        data: {'action' : 'generateQuiz', 'isAjax' : true},
        dataType: "JSON",
        success: function(result) {
            alert('done');
        },
        error: function (e) {
            alert(this.url);
        }
    });
}