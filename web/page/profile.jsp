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
            <p>
                <c:out value="${currentUser.userName}" />
            </p>
        </div>
    </main>
<jsp:include page="/page/link/footer.jsp"/>
