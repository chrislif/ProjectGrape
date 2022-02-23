<%-- 
    Document   : addQuestion
    Created on : Feb 18, 2022, 2:07:30 PM
    Author     : Dadvid
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/page/link/header.jsp"/>

<main>
    <div class="mainContent">
        <h2>Fill out the form to add the question</h2>

        <form action="private" method="post">
            <input type="hidden" name="action" value="toQuestionPool">

            <label for="tag">What type of question is this?</label>
            <select name="tag" id="tag">
                <option value="Addition">Addition</option>
                <option value="Subtraction">Subtraction</option>
                <option value="Multiplication">Multiplication</option>
                <option value="Division">Division</option>
            </select>

            <label for="questionText">Question Text:</label>
            <input type="text" name="questionText" id="questionText">

            <label for="questionAnswer">Question Answer:</label>
            <input type="text" name="questionAnswer" id="questionAnswer">

            <label for="questionLevels">How difficult is the question</label><br>
            <select name="questionLevels" id="questionLevels">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select>
            
            <input type="submit" value="Add Question">
        </form>
    </div>
</main>

<jsp:include page="/page/link/footer.jsp"/>
