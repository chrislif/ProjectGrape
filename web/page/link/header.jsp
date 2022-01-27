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
        <link rel="stylesheet" href="Views/link/style.css">
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
                            <input type="hidden" name="action" value="home">
                            <input type="submit" value="Home" class="navbutton">
                        </form>
                    </li>
                    <li>
                        <form action="private" method="post">
                            <input type="hidden" name="action" value="profile">
                            <input type="submit" value="Profile" class="navbutton">
                        </form>
                    </li>
                    <li>
                        <form action="private" method="post">
                            <input type="hidden" name="action" value="test">
                            <input type="submit" value="Test" class="navbutton">
                        </form>
                    </li>
                    <li>
                        <form action="private" method="post">
                            <input type="hidden" name="action" value="drill">
                            <input type="submit" value="Drill" class="navbutton">
                        </form>
                    </li>
                    <li>
                        <form action="public" method="post">
                            <input type="hidden" name="action" value="login">
                            <input type="submit" value="Login" class="navbutton">
                        </form>
                    </li>
                </ul>
            </div>
        </nav>
        