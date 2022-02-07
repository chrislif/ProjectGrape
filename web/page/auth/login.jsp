<%-- 
    Document   : login
    Created on : Jan 26, 2022, 5:54:07 PM
    Author     : chris
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/page/link/header.jsp"/>
    <main>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
        <script type="text/javascript">
            const errorJSON = JSON.parse('${errorList}');
        </script>
        <script type="text/javascript" src="page/auth/login.js"></script>
        <div class="mainContent">
            <div class="gridWrapper">
                <div class="gridSubContent">
                    <form action="public" method="post">
                        <input type="hidden" name="action" value="authorize">
                        <div>
                            <p>
                                Username: 
                            </p>
                            <input type="text" name="username" value="${username}">
                        </div>
                        <div style="margin-top: 15px;">
                            <p>
                                Password: 
                            </p>
                            <input type="password" name="password" value="${password}">
                        </div>
                        <input type="submit" value="Login" class="styledButton">
                    </form>
                </div>
                <div class="gridSubContent">
                    <h2>Welcome to MathWiz!</h2>
                    <div>
                        <p>
                            If you are a new user then register here:
                        </p>
                        <form action="public" method="post">
                            <input type="hidden" name="action" value="toRegister">
                            <input type="submit" value="Register" class="styledButton">
                        </form>
                    </div>
                    <p>If you forgot your password then click here:</p>
                    <form action="public" method="post">
                        <input type="hidden" name="action" value="toReset">
                        <input type="submit" value="Reset Password" class="styledButton">
                    </form>
                </div>
                <div class="gridSubContent" id="errorDisplay">
                </div>
            </div>
        </div>
    </main>
<jsp:include page="/page/link/footer.jsp"/>
