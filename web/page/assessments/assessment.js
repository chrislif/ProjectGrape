"use strict";

var questionList;

$(document).ready(() => {

    $("#startQuiz").click(startQuiz);
});

class Score {
    constructor(userAnswer, correctAnswer) {
        this.userAnswer = userAnswer;
        this.correctAnswer = correctAnswer;
        this.isCorrect = false;
    }
}

function startQuiz() {
    var questionLevel = $("#questionLevels").find(":selected").text();
    
    var questionType = $("#questionType").find(":selected").text();
    
    $.ajax({
        type: "POST",
        url: "private",
        data: {'action' : 'generateQuiz', 'questionLevels' : questionLevel, 'questionType' : questionType},
        dataType: "JSON",
        success: function(result) {
            questionList = JSON.parse(result);
            
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
    
    var quizAnswerTexts = $("input[type='text']");
    
    var scoreList = [];
    
    var answers = [];
    
    //Add Validation
    
    for (let i = 0; i < quizAnswerTexts.length; i++  ) {
        answers.push(parseInt(quizAnswerTexts[i].value));
    }

    for (let i = 0; i <questionList.length; i++) {
        var newScore = new Score(answers[i] ,parseInt(questionList[i].questionAnswer));
        
        if (answers[i] === parseInt(questionList[i].questionAnswer)) {
           newScore.isCorrect = true;
        } else {
           newScore.isCorrect = false;
        }
        
        scoreList.push(newScore);
    }
    
    return scoreList;
}

function clearQuiz() {
    $("#quiz").empty();
    
    $("#subContent").show();
}
