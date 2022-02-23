<%-- 
    Document   : index
    Created on : Jan 26, 2022, 3:53:09 PM
    Author     : chris
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/page/link/header.jsp"/>
    <main>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
        <script type="text/javascript" src="index.js"></script>
        <div class="mainContent">
            <h1>
                Welcome to Team Grape's MathWiz
            </h1>
            <div class="subContent">
                <h2 class="content-header">
                    What is MathWiz?
                </h2>
                
                <p>MathWiz is the go to tutoring platform for teachers and students alike.</p>
            </div>
            
            <div class="subContent">
                <form>
                    <label>Name: </label><input type="text" id="nameInput"><br>
                    <input type="button" value="Hello" id="helloButton" class="styledButton"><br>
                    <span id="output"></span>
                </form>
            </div>
        </div>
    </main>
<jsp:include page="/page/link/footer.jsp"/>
