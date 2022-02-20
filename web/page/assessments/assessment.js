"use strict";

var quiz;

$(document).ready(() => {
    $("#startQuiz").click(startQuiz);
});

class Grade {
    constructor(quizID, scoreList) {
        this.quizID = quizID;
        this.scoreList = scoreList;
    }
}

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
            quiz = JSON.parse(result);
            
            displayQuiz(quiz.questionList);
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
    
    var answers = [];
    var isValid = validateAnswers(answers);
    var scoreList = [];
    
    //Add Validation
    if (isValid === false) {
        alert('Make sure every answer is filled out & is a Number');
    } else {
        for (let i = 0; i < quiz.questionList.length; i++) {
            var newScore = new Score(answers[i] ,parseInt(quiz.questionList[i].questionAnswer));

            if (answers[i] === parseInt(quiz.questionList[i].questionAnswer)) {
               newScore.isCorrect = true;
            } else {
               newScore.isCorrect = false;
            }

            scoreList.push(newScore);
        }
        
        var finalGrade = new Grade(quiz.assessmentID, scoreList);
        
        storeGrade(finalGrade);
        displayScores(scoreList);
    }
}

function storeGrade(finalGrade) {
    let gradeJSON = JSON.stringify(finalGrade);
    
    $.ajax({
        type: "POST",
        url: "private",
        data: {'action' : 'storeScore', 'gradeJSON' : gradeJSON},
        dataType: "JSON",
        success: function(result) {
            alert("quiz complete!");
            alert(result);
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

function validateAnswers(answers) {
    var quizAnswerTexts = $("input[type='text']");
    var isValid = true;
    
    for (let i = 0; i < quizAnswerTexts.length; i++) {
        if(quizAnswerTexts[i].value === "" || isNaN(parseInt(quizAnswerTexts[i].value))){
            isValid = false;
        }
        answers.push(parseInt(quizAnswerTexts[i].value));
    }
    
    return isValid;
}
