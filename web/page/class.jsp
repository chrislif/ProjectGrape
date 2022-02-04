<%-- 
    Document   : class
    Created on : Feb 4, 2022, 12:28:25 PM
    Author     : Dadvid
--%>

<jsp:include page="/page/link/header.jsp"/>
<main>
    <div class="mainContent">
        <h2>
            Classroom
        </h2>

        <div class="subContent">
            <h2>Welcome to Class</h2>
            <p>Would you like to take a test, quiz, or drill?</p>
            <form action="private" method="post">
                <input type="hidden" name="action" value="toQuiz">
                <input type="submit" value="Quiz">
            </form>
            
            <form action="private" method="post">
                <input type="hidden" name="action" value="toTest">
                <input type="submit" value="Test">
            </form>

            <form action="private" method="post">
                <input type="hidden" name="action" value="toDrill">
                <input type="submit" value="Drill">
            </form>
        </div>
    </div>
</main>
<jsp:include page="/page/link/footer.jsp"/>
