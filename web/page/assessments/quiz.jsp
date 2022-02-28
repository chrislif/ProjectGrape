<%-- 
    Document   : quiz
    Created on : Feb 4, 2022, 12:38:39 PM
    Author     : Dadvid
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/page/link/header.jsp"/>
<main>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <script type="text/javascript" src="page/assessments/assessment.js"></script>
    <div class="mainContent">
        <h1>
            Quiz
        </h1>

        <div class="subContent" id="subContent">
            <div class="para-content">
                <h2>Customize your Quiz</h2><br>
                <label>What difficulty would you like to attempt?</label><br>
                <select name="questionLevels" id="questionLevels">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>

                <select name="questionType" id="questionType">
                    <option value="Addition">Addition</option>
                    <option value="Subtraction">Subtraction</option>
                    <option value="Multiplication">Multiplication</option>
                    <option value="Division">Division</option>
                </select><br>

                <input type="submit" id="startQuiz" class="styledButton" value="Start Quiz!">
            </div>
        </div>

        <div class="quiz" id="quiz-container">
        </div>
    </div>
</main>
<jsp:include page="/page/link/footer.jsp"/>
