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
    
    quiz.append('<div class="subContent"><ol id="quiz"> </ol></div>');
    
    for(let i in questionList) {
        $('#quiz').append('<li>' + questionList[i].questionText + '<br>' +
                "<input type=text id=question" + i + ' ' +'</li>');
    }
    quiz.append("<input type='button' class='styledButton' id='processQuiz' onclick='processQuiz()' value='Submit Quiz!'>");
}

function processQuiz() {
    
    var quizAnswerTexts = $("input[type='text']");
    
    var scoreList = [];
    
    var answers = [];
    
    //Add Validation
    
    for (let i = 0; i < quizAnswerTexts.length; i++  ) {
        answers.push(parseInt(quizAnswerTexts[i].value));
    }

    for (let i = 0; i < questionList.length; i++) {
        var newScore = new Score(answers[i] ,parseInt(questionList[i].questionAnswer));
        
        if (answers[i] === parseInt(questionList[i].questionAnswer)) {
           newScore.isCorrect = true;
        } else {
           newScore.isCorrect = false;
        }
        
        scoreList.push(newScore);
    }
    
    displayScores(scoreList);
    return scoreList;
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
    $("#quiz").empty();
    $("#quiz-container").empty();
    
    $("#quiz-container").hide();
    
    $("#subContent").show();
}
