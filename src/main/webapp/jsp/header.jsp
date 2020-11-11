
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Astana IT University</title>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="node_modules/mdbootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="node_modules/mdbootstrap/css/mdb.min.css">
    <link rel="stylesheet" href="node_modules/mdbootstrap/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Assistant:wght@600&family=Patua+One&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mainstyle.css">
    <script>
        <%@include file="../js/javascript.js"%>
    </script>
</head>
<body class="d-flex flex-column h-100">
<nav class="navbar navbar-inverse navbar-expand-lg" id="asd">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}"><img style="width: 60px;" src="https://astanait.edu.kz/wp-content/uploads/2020/05/aitu-logo-white-2-300x154.png"></a>
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="glyphicon glyphicon-menu-hamburger"></span></button>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="nav navbar-nav">

                <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>

                <li><a href="${pageContext.request.contextPath}/jsp/Sport.jsp">News</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/Gadgets.jsp">Clubs</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/Clothes.jsp">Events</a></li>

                <c:if test="${cookie.user.value != null}">

                </c:if>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${cookie.user.value != null}">
                    <li><a href="<%=application.getContextPath()%>/jsp/Cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
                </c:if>

                <c:if test="${cookie.user.value.length()>0}">
                    <li class="border border-primary"><a href="#" class="border border-primary"><span class="glyphicon glyphicon-user"></span> ${cookie.user.value}</a>  </li>
                    <li><a href="${pageContext.request.contextPath }/logout" type="submit"> <span class="glyphicon glyphicon-user"></span>Logout</a></li>
                </c:if>

                <c:if test="${cookie.user.value == null}">
                    <li><a href="<%=application.getContextPath()%>/jsp/loginregister.jsp"><span class="glyphicon glyphicon-user"></span> Authorize </a></li>
                </c:if>

            </ul>
                <form class="navbar-form navbar-left">
                    <div class="form-group searchBook">
                        <input type="text" name="productName" id="spname" class="form-control" placeholder="Search">
                    </div>
                    <button type="btn" name="search" id="sbtn" class="btn btn-default">Search</button>
                </form>
        </div>
    </div>
</nav>
<br><br><br>
