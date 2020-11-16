
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Welcome to AITU</title>
    <script>
        <%@include file="/js/javascript.js"%>
    </script>
    <link href="https://fonts.googleapis.com/css2?family=Hind&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Hammersmith+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@800&display=swap" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <link href="${pageContext.request.contextPath}/css/Main.css" rel="stylesheet">
</head>
<body class="d-flex flex-column h-100">
<%@include file="jsp/header.jsp"%>
<div class="page-photo" style="background-image: linear-gradient(rgba(0,0,0,0), rgba(0,0,0,0.7)),url('${pageContext.request.contextPath}/images/aitu-e1589799195486.png');">
    <div class="left-text">
        <h1>Astana IT University</h1>
    </div>
    <div class="right-text">
        <P>Astana IT University delivers digital transformation through teaching, research and successful innovation.</P>
    </div>
</div>


<%@include file="jsp/footer.jsp"%>


</body>

</html>