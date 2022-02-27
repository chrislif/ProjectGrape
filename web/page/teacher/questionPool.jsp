<%-- 
    Document   : questionPool
    Created on : Feb 18, 2022, 2:07:15 PM
    Author     : Dadvid
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/page/link/header.jsp"/>
<main>
    <div class='mainContent'>
        <div class='subContent addQuestionDiv'>
            <h2 class="addQuestionTitle">Add a Question to the Pool</h2>

            <form action="private" method="post" class="addQuestionForm">
                <input type="hidden" name="action" value="addQuestionToPool">

                <label for="tag">Question Type:</label>
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

                <label for="questionLevels">Question Difficulty:</label><br>
                <select name="questionLevels" id="questionLevels">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>

                <input type="submit" value="Add Question" class="">
            </form>
        </div>
        <div class='subContent questionPool'>
            <h1 class="questionPool-Title">Question Pool</h1>

            <table>     
                <tr>
                    <th>ID</th>
                    <th>Level</th>
                    <th>Question</th>
                    <th>Answer</th>
                </tr>


                <c:forEach items="${questionList}" var="question"> 
                    <tr>
                        <td>${question.questionID}</td>
                        <td>${question.questionLevel}</td>
                        <td>${question.questionText}</td>
                        <td>${question.questionAnswer}</td>
                    </tr>
                </c:forEach>

            </table>   
        </div>

    </div> 
</main>

<jsp:include page="/page/link/footer.jsp"/>