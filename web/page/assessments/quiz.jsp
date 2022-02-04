<%-- 
    Document   : quiz
    Created on : Feb 4, 2022, 12:38:39 PM
    Author     : Dadvid
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/page/link/header.jsp"/>
    <main>
        <div class="mainContent">
            <h2>
                Quiz
            </h2>
            
            <div class="subContent">
                <form action="private" method="post">
                    <input type="hidden" name="action" value="generateQuiz">
                    
                    <label>What difficulty would you like to attempt?</label><br>
                    <select name="questionLevels">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select> <br>
                    
                    <input type="submit" value="Start Quiz!">
                </form>
            </div>
        </div>
    </main>
<jsp:include page="/page/link/footer.jsp"/>