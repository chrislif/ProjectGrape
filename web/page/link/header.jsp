<%-- 
    Document   : header
    Created on : Jan 26, 2022, 3:54:58 PM
    Author     : chris
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project Grape</title>
        <link rel="stylesheet" href="page/link/style.css">
    </head>
    <body>
        <header>
            <div class="headerContent">
                <h1>MathWiz</h1>
                <p>Math Learning Suite</p>
            </div>
        </header>
        <nav>
            <div class="navbar">
                <ul class="navlist">
                    <li>
                        <form action="public" method="post">
                            <input type="hidden" name="action" value="toHome">
                            <input type="submit" value="Home" class="navbutton">
                        </form>
                    </li>
                    <c:if test="${currentUser != null}">
                        <li>
                            <form action="private" method="post">
                                <input type="hidden" name="action" value="toProfile">
                                <input type="submit" value="<c:out value="${currentUser.userName}" />'s Profile" class="navbutton">
                            </form>
                        </li>
                    </c:if>
                        <li>
                            <form action="private" method="post">
                                <input type="hidden" name="action" value="toClass">
                                <input type="submit" value="Classroom" class="navbutton">
                            </form>
                        </li>
                    
                    <c:if test="${currentUser == null}">
                        <li>
                            <form action="public" method="post">
                                <input type="hidden" name="action" value="toLogin">
                                <input type="submit" value="Login" class="navbutton">
                            </form>
                        </li>
                    </c:if>
                    <c:if test="${currentUser != null}">
                        <li>
                            <form action="private" method="post">
                                <input type="hidden" name="action" value="logout">
                                <input type="submit" value="Logout" class="navbutton">
                            </form>
                        </li>
                    </c:if>
                </ul>
            </div>
        </nav>
        