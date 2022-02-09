<%-- 
    Document   : quiz
    Created on : Feb 4, 2022, 12:38:39 PM
    Author     : Dadvid
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/page/link/header.jsp"/>
    <main>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
        <script type="text/javascript"></script>
        <script type="text/javascript" src="page/assessments/assessmentScript.js"></script>
        <div class="mainContent">
            <h2>
                Quiz
            </h2>
            
            <div class="subContent">
<!--                <form action="private" method="post">-->
                    <input type="hidden" name="action" value="generateQuiz">
                    
                    <label>What difficulty would you like to attempt?</label><br>
                    <select name="questionLevels" id="questionLevels">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select> <br>
                    
                    <input type="submit" id="startQuiz" value="Start Quiz!">
                <!--</form>-->
            </div>
        </div>
    </main>
<jsp:include page="/page/link/footer.jsp"/>