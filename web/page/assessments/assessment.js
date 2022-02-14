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
        },
        error: function (e) {
            alert(this.url);
        }
    });
}

function displayQuiz(questionList) {
    $("#subContent").hide();
    
    var quiz = $("#quiz-container");
    
    quiz.append('<div class="subContent"><ol id="quiz"> </ol></div>');
    
    for(let i in questionList) {
        $('#quiz').append('<li>' + questionList[i].questionText + '</li>' + '<br>' +
                "<input type=text id=question" + i + " class=quizQuestion>");
    }
    quiz.append("<input type='button' class='styledButton' id='endQuiz' onclick='endQuiz()' value='Submit Quiz!'>");
}

function endQuiz() {
    
    var quizQuestions = $(".quizQuestion");
    for (let question of quizQuestions) {
        alert($(question.val()));
    }
    
}

function clearQuiz() {
    $("#quiz").empty();
    
    $("#subContent").show();
}
