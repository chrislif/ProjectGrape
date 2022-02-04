<%-- 
    Document   : login
    Created on : Jan 26, 2022, 5:54:07 PM
    Author     : chris
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/page/link/header.jsp"/>
    <main>
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
                        <input type="submit" value="Register" class="styledButton">
                    </form>
                </div>
                <div class="gridSubContent">
                    <p>
                        Students: Ask you teacher for a Username and Password!
                    </p>
                </div>
                <div class="gridSubContent">
                    <ul class="errorList">
                        <c:forEach items="${errorList}" var="error">
                            <li>${error}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </main>
<jsp:include page="/page/link/footer.jsp"/>
