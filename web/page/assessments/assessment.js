"use strict";

$(document).ready(() => {
    $("#startQuiz").click(startQuiz);
});

function startQuiz() {
    var questionLevel = $("#questionLevels").find(":selected").text();
    
    var questionType = $("#questionType").find(":selected").text();
    
    $.ajax({
        type: "POST",
        url: "private",
        data: {'action' : 'generateQuiz', 'questionLevels' : questionLevel, 'questionType' : questionType},
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
        $('#quiz').append('<li>' + questionList[i].questionText + '<br>' +
                "<input type=text id=question" + i + " class=quizQuestion>" + '</li>');
    }
    quiz.append("<input type='button' class='styledButton' id='endQuiz' onclick='endQuiz()' value='Submit Quiz!'>");
}

function endQuiz() {
    
    var quizQuestions = $("#quiz quizQuestion");
    console.log(quizQuestions[0]);
    
}

function clearQuiz() {
    $("#quiz").empty();
    
    $("#subContent").show();
}
