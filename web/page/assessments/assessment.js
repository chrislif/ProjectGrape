"use strict";

$(document).ready(() => {
    $("#startQuiz").click(startQuiz);
});

function startQuiz() {
    var questionLevel = $("#questionLevels").find(":selected").text();
    
    $.ajax({
        type: "POST",
        url: "private",
        data: {'action' : 'generateQuiz', 'questionLevels' : questionLevel},
        dataType: "JSON",
        success: function(result) {
            var questionList = JSON.parse(result);
            
            displayQuiz(questionList);
            
            alert(questionList.length);
        },
        error: function (e) {
            alert(this.url);
        }
    });
}

function displayQuiz(questionList) {
    for(let i in questionList) {
        
    }
}