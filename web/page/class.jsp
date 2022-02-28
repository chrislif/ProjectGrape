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
            <h1>Welcome to Class</h1>
            <div class="subContent">
                <div class="para-content">
                    <p>
                        Here you can hone your knowledge on various subjects by taking quiz's. Modify the challenge of these 
                        quizzes to your liking and feel free to increase the difficulty level to really test your knowledge.
                    </p>
                    <p>Click the link below to get started!</p>
                </div>
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
            <h1>Here is your Classroom</h1>
            <div class="subContent">
                <!--                                
                <h2>To Create a Test Click Here!</h2>
                    <input class="styledButton" type="button" value="Create a Test">
    
                <h2>Add Questions to the Question Pool</h2>
                <form action="private" method="post">
                    <input type="hidden" name="action" value="toAddQuestion">
                    <input type="submit" value="Add Question" class="styledButton">
                </form>-->
                <div class="para-content">
                    <p>
                        With the link below you can add questions to your classroom's question pool.
                        Each question will be displayed for you to look through as well!
                    </p>
                </div>

                <form action="private" method="post">
                    <input type="hidden" name="action" value="toQuestionPool">
                    <input type="submit" value="Question Pool" class="styledButton">
                </form>

            </div>
            <div class='subContent'>
                <h1>Current Students</h1>

                <table>     
                    <tr>
                        <th>Student Name</th>
                        <th>Nickname</th>
                    </tr>
                    <c:forEach items="${studentList}" var="student"> 
                        <tr>
                            <td>${student.userName}</td>
                            <td>${student.nickname}</td>
                        </tr>
                    </c:forEach>

                </table>   
            </div>
        </c:if>


    </div>
</main>
<jsp:include page="/page/link/footer.jsp"/>
