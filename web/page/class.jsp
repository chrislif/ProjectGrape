<%-- 
    Document   : class
    Created on : Feb 4, 2022, 12:28:25 PM
    Author     : Dadvid
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/page/link/header.jsp"/>
<main>  
    <div class="mainContent">

        <c:if test="${currentUser.type == 'Student'}">
            <h2>Welcome to Class</h2>
            <div class="subContent">

                <p>
                    Here you can hone your knowledge on various subjects by taking quiz's. Customize the challenge of these 
                    quizzes to your liking and feel free to move up a level to really test your knowledge
                </p>
                <h2>Study, Study, Study!</h2>
                <form action="private" method="post">
                    <input type="hidden" name="action" value="toQuiz">
                    <input type="submit" value="Quiz" class="styledButton">
                </form>

                <!--            
                <form action="private" method="post">
                    <input type="hidden" name="action" value="toTest">
                    <input type="submit" value="Test" class="styledButton">
                </form>
                
                <form action="private" method="post">
                    <input type="hidden" name="action" value="toDrill">
                    <input type="submit" value="Drill" class="styledButton">
                </form>-->
            </div>
        </c:if>

        <c:if test="${currentUser.type == 'Teacher'}">
            <h2>Here is your Classroom</h2>
            <div class="subContent">


            <!--                                
            <h2>To Create a Test Click Here!</h2>
                <input class="styledButton" type="button" value="Create a Test">

            <h2>Add Questions to the Question Pool</h2>
            <form action="private" method="post">
                <input type="hidden" name="action" value="toAddQuestion">
                <input type="submit" value="Add Question" class="styledButton">
            </form>-->

            <h2>View all the Questions in the Question Pool <br>
                Add More Questions to the Question Pool</h2>
                <form action="private" method="post">
                    <input type="hidden" name="action" value="toQuestionPool">
                    <input type="submit" value="Question Pool" class="styledButton">
                </form>
            </div>
        </c:if>


    </div>
</main>
<jsp:include page="/page/link/footer.jsp"/>
