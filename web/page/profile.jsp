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
                <c:out value="${currentUser.userName}" />
            </h2>
            <p>
                Email: <c:out value="${currentUser.email}" />
            </p>
            <br>
            <p>
            <form action="private" method="post">
                <input type="hidden" name="action" value="updateEmail">
                <input type="text" id="emailInput">
                <input type="submit" value="Update Email" class="styledButton">
            </form>

            </p>
        </div>
        <div class="subContent">
            <h2>Grades</h2>
        </div>
    </div>
</main>
<jsp:include page="/page/link/footer.jsp"/>
