<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/css/Main.css" rel="stylesheet">

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/"><img
                src="${pageContext.request.contextPath}/images/logo.png" style="width: 150px;height: 75px;"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/clubservlet"
                       style="text-align: center;">Clubs <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/eventservlet"
                       style="text-align: center;">Events</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/newservlet"
                       style="text-align: center;">News</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/userservlet"
                       style="text-align: center;">Students</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <c:if test="${cookie.user.value == null}">
                        <a href="${pageContext.request.contextPath}/jsp/login.jsp">
                            <button type="button" class="btn btn-success">Log In</button>
                        </a>
                    </c:if>
                </li>
                <c:if test="${cookie.user.value.length()>0}">
                    <li class="nav-item">
                        <h5>${cookie.user.value}</h5>
                    </li>
                    &nbsp;
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/logout">
                            <button type="button" class="btn btn-danger">Log Out</button>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
        <div class="login-logup" style="float: right;">


        </div>
    </nav>
</header>
