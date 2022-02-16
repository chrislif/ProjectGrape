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
            const errorJSON = JSON.parse('${errorListJSON}');
        </script>
        <script type="text/javascript" src="page/auth/register.js"></script>
        <div class="mainContent">
            <h2>
                Register
            </h2>
            <div class="gridWrapper">
                <div class="gridSubContent">
                    <form action="public" method="post">
                        <input type="hidden" name="action" value="register">
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
                        <div style="margin-top: 15px;">
                            <p>
                                Re-enter Password: 
                            </p>
                            <input type="password" name="passwordCheck" value="${passwordCheck}">
                        </div>
                        <div style="margin-top: 15px;">
                            <p>
                                Account:
                            </p>
                            <input type="radio" name="type" value="Student" checked>
                            <label for="Student">Student</label>
                            <input type="radio" name="type" value="Teacher">
                            <label for="Teacher">Teacher</label>
                        </div>
                        <div style="margin-top: 15px;">
                            <p>
                                Classroom: 
                            </p>
                            <input type="text" name="classroom">
                        </div>
                        <input type="submit" value="Register" class="styledButton">
                    </form>
                </div>
                <div class="gridSubContent">
                    <p>
                        Students: Ask you teacher for a Username and Password!
                    </p>
                </div>
                <div class="gridSubContent" id="errorDisplay">
                </div>
            </div>
        </div>
    </main>
<jsp:include page="/page/link/footer.jsp"/>
