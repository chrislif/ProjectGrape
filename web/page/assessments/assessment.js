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
    
    quiz.show();
    quiz.append('<div class="subContent"> <div id="errorList"></div>\n\
                    <ol id="quiz"> </ol>\n\
                    </div>');
    
    for(let i in questionList) {
        $('#quiz').append('<li>' + questionList[i].questionText + '<br>' +
                "<input type=text id=question" + i + ' ' +'</li>');
    }
    quiz.append("<input type='button' class='styledButton' id='processQuiz' onclick='processQuiz()' value='Submit Quiz!'>");
}

function processQuiz() {
    var quizAnswerTexts = $("input[type='text']");
    
    var isValid = validateAnswers();
    var scoreList = [];
    var answers = [];
    
    //Add Validation
    if (isValid === false) {
        $("#errorList").val('<p>Make sure every answer is filled out & is a Valid INTEGER</p>');
    } else {
        for (let i = 0; i < questionList.length; i++) {
            var newScore = new Score(answers[i] ,parseInt(questionList[i].questionAnswer));

            if (answers[i] === parseInt(questionList[i].questionAnswer)) {
               newScore.isCorrect = true;
            } else {
               newScore.isCorrect = false;
            }

            scoreList.push(newScore);
        }
        storeScore(scoreList);
        displayScores(scoreList);
    }
}

function storeScore(scoreList) {
    let scoreListJSON = JSON.stringify(scoreList);
    
    $.ajax({
        type: "POST",
        url: "private",
        data: {'action' : 'storeScore', 'scoreListJSON' : scoreListJSON},
        dataType: "JSON",
        success: function(result) {
            alert("quiz complete!");
        },
        error: function (e) {
            alert(this.url);
        }
    });
}

function displayScores(scoreList) {
    
    $("#processQuiz").hide();
    
    $("#quiz-container").append("<input type='button' class='styledButton' id='processQuiz' onclick='clearQuiz()' value='Clear Scores'>");
    
    for (let i in scoreList){
        if (scoreList[i].isCorrect === true){
            $("#question"+i).addClass("correctAnswer");
        } else if (scoreList[i].isCorrect === false){
            $("#question"+i).addClass("incorrectAnswer");
        }
        
        $('#question'+i).before("<p> Correct Answer: " + scoreList[i].correctAnswer + "</p>");
    }
}

function clearQuiz() {
    $(".quiz").empty();
    
    $("#subContent").show();
}

function validateAnswers() {
    var quizAnswerTexts = $("input[type='text']");
    
    for (let i = 0; i < quizAnswerTexts[i].length; i++) {
        if(isNaN(quizAnswerTexts[i].text) || quizAnswerTexts[i].text === null){
            return false;
        } else {
            return true;
        }
    }
}
