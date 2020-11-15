
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Main.css">
    <script>
        <%@include file="../js/javascript.js"%>
    </script>
    <link href="https://fonts.googleapis.com/css2?family=Hind&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Hammersmith+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@800&display=swap" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</head>
<body style="margin: 0;">
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="Main.html"><img src="${pageContext.request.contextPath}/images/logo.png" style="width: 150px;height: 75px;"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/clubservlet" style="text-align: center;">Clubs <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/eventservlet" style="text-align: center;">Events</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/newservlet" style="text-align: center;">News</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/userservlet" style="text-align: center;">Students</a>
                </li>
            </ul>
        </div>
        <div class="login-logup" style="float: right;">
            <c:if test="${cookie.user.value == null}">
                <a href="${pageContext.request.contextPath}/jsp/login.jsp"><button type="button" class="btn btn-success">Log In</button></a>
            </c:if>

            <c:if test="${cookie.user.value.length()>0}">
                <p style="font-size: 20px;">${cookie.user.value}</p>
                <a href="${pageContext.request.contextPath}/logout"><button type="button" class="btn btn-danger">Log Out</button></a>
            </c:if>
        </div>
    </nav>
</header>
