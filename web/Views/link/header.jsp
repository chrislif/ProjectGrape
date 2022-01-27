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
                <p>Math Learning Site</p>
            </div>
        </header>
        <nav>
            <div class="navbar">
                <ul class="navlist">
                    <li>
                        <a href="/ProjectGrape/public?action=home">Home</a>
                    </li>
                    
                    <li>
                        <a href="/ProjectGrape/private?action=profile">Profile</a>
                    </li>
                    
                    <li>
                        <a href="/ProjectGrape/private?action=assessment">Assessment</a>
                    </li>
                    
                    <li>
                        <a href="/ProjectGrape/public?action=login">Login</a>
                    </li>
                </ul>
            </div>
        </nav>