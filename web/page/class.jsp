<%-- 
    Document   : class
    Created on : Feb 4, 2022, 12:28:25 PM
    Author     : Dadvid
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/page/link/header.jsp"/>
<main>  
    <div class="mainContent">
        <h2>
            Classroom
        </h2>
        
        <c:if test="${accountType == 'Student'}">
        <div class="subContent">
            <h2>Welcome to Class</h2>
            <p>Would you like to take a test, quiz, or drill?</p>
            <form action="private" method="post">
                <input type="hidden" name="action" value="toQuiz">
                <input type="submit" value="Quiz" class="styledButton">
            </form>
            
            <form action="private" method="post">
                <input type="hidden" name="action" value="toTest">
                <input type="submit" value="Test" class="styledButton">
            </form>

            <form action="private" method="post">
                <input type="hidden" name="action" value="toDrill">
                <input type="submit" value="Drill" class="styledButton">
            </form>
        </div>
        </c:if>
        
        <c:if test="${accountType == 'Teacher'}">
            <div class="subContent">
                <h2>Students in Classroom</h2>
                
                <h2>To Create a Test Click Here!</h2>
                <input class="styledButton" type="button" value="Create a Test">
                
                <h2>Add Questions to the Question Pool</h2>
                <form action="private" method="post">
                    <input type="hidden" name="action" value="toAddQuestion">
                    <input type="submit" value="Add Question" class="styledButton">
                </form>
                
                <h2>View All Questions in the Question Pool</h2>
                <form action="private" method="post">
                    <input type="hidden" name="action" value="toQuestionPool">
                    <input type="submit" value="Question Pool" class="styledButton">
                </form>
            </div>
        </c:if>

        
    </div>
</main>
<jsp:include page="/page/link/footer.jsp"/>
