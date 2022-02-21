<%-- 
    Document   : profile
    Created on : Jan 26, 2022, 5:53:43 PM
    Author     : chris
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/page/link/header.jsp"/>
<main>
    <div class="mainContent">
        <h1 class="headerContent">
            <c:out value="${currentUser.type}"/> - Profile
        </h1>
        <div class="subContent">
            <h2>
                User Name: <c:out value="${currentUser.userName}" />
            </h2>
            <p>
                Email: <c:out value="${currentUser.email}" /><br>

                Account ID: <c:out value="${currentUser.accountID}" /> <br>
                
            </p>

            <form action="private" method="post">
                <input type="hidden" name="action" value="updateUserName">
                <input type="text" name="userName" value="${currentUser.userName}">
                <input type="submit" value="Update User Name" class="styledButton">
            </form>                

            <form action="private" method="post">
                <input type="hidden" name="action" value="updateEmail">
                <input type="text" name="emailInput" value="${currentUser.email}">
                <input type="submit" value="Update Email" class="styledButton">
            </form>

            <form action="private" method="post">
                <input type="hidden" name="action" value="updatePassword">
                <input type="text" name="password" value="">
                <input type="submit" value="Update Password" class="styledButton">
            </form>
                
                <p id="message"></p>
        </div>
        <div class="subContent">
            <h2>Grades</h2>
            
            <c:forEach items="${gradeList}" var="grade">
                <p>${grade.assessmentID}</p>
            </c:forEach>
        </div>
    </div>
</main>
<jsp:include page="/page/link/footer.jsp"/>
