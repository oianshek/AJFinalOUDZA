<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Club</title>
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

    <style>
        .grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
            grid-column-gap: 20px;
            grid-row-gap: 20px;
            padding: 10px;
        }
        .grid-button {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            grid-column-gap: 20px;
            grid-row-gap: 20px;
            padding: 20px;
        }

        .box{
            background-color: #000;
            font-family: 'Oxygen', sans-serif;
            border-radius: 0 30px;
            overflow: hidden;
            position: relative;
            z-index: 1;
            transition: all 0.3s ease 0.3s;
        }
        .box:hover{ background-color: #44bd32; }
        .box:before,
        .box:after,
        .box .box-content:before,
        .box .box-content:after{
            content: '';
            background-color: #44bd32;
            width: 100%;
            height: 5px;
            position: absolute;
            top: 0;
            left: -100%;
            transition: all 0.4s ease-in;
        }
        .box:after{
            top: auto;
            bottom: 0;
            left: 100%;
        }
        .box .box-content:before{
            width: 5px;
            height: 100%;
            top: 100%;
            left: 0;
        }
        .box .box-content:after{
            width: 5px;
            height: 100%;
            top: -100%;
            left: auto;
            right: 0;
        }
        .box:hover:before,
        .box:hover:after{
            opacity: 0.2;
            left: 0;
        }
        .box:hover .box-content:before,
        .box:hover .box-content:after{
            opacity: 0.2;
            top: 0;
        }
        .box img{
            width: 100%;
            height: auto;
            transition: all 0.3s ease;
        }
        .box:hover img{ opacity: 0.35; }
        .box .box-content{
            color: #fff;
            height: 100%;
            width: 100%;
            padding: 15px 0 0 15px;
            opacity: 0;
            position: absolute;
            top: 20px;
            left: 0;
            transition: all 0.45s ease;
        }
        .box:hover .box-content{
            opacity: 1;
            top: 0;
        }
        .box .title{
            font-size: 22px;
            font-weight: 700;
            letter-spacing: 1px;
            text-transform: uppercase;
            text-shadow: 0 0 10px rgba(0,0,0,0.5);
            margin: 0 0 4px;
        }
        .box .post{
            font-size: 16px;
            letter-spacing: 1px;
            text-transform: lowercase;
            text-shadow: 0 0 10px rgba(0,0,0,0.5);
            margin: 0 0 5px;
            display: block;
        }
        .box .icon{
            padding: 0;
            margin: 0;
            list-style: none;
            opacity: 0;
            transform: rotate(-45deg);
            position: absolute;
            bottom: 15px;
            right: 15px;
            transition: all 0.4s cubic-bezier(0.6, -0.8, 0.735, 0.045);
        }
        .box:hover .icon{
            opacity: 1;
            transform: rotate(0deg);
        }
        .box .icon li{ display: inline-block;  }
        .box .icon li a{
            color: #fff;
            background-color: #44bd32;
            font-size: 16px;
            text-align: center;
            line-height: 38px;
            width: 40px;
            height: 40px;
            margin: 0 5px;
            border-radius: 50%;
            border: 2px solid #fff;
            display: block;
            position: relative;
            transition: all 0.3s ease 0s;
        }
        .box .icon li  a:hover{ box-shadow: 0 0 15px rgba(0,0,0,0.5); }
        .box .icon li  a:hover:after{
            content: "";
            width: 100%;
            height: 100%;
            border-radius: 50%;
            position: absolute;
            top: 0;
            left: 0;
            animation: animate 0.5s ease-out 75ms;
        }
        @keyframes animate{
            0%{ opacity: 0.3; }
            40%{
                opacity: 0.5;
                box-shadow: 0 0 0 2px rgba(255,255,255,0.1), 0 0 10px 10px #fff, 0 0 0 10px rgba(255,255,255,0.5);
            }
            100%{
                box-shadow: 0 0 0 2px rgba(255,255,255,0.1), 0 0 10px 10px #fff, 0 0 0 10px rgba(255,255,255,0.5);
                transform: scale(1.5);
                opacity: 0;
            }
        }
        @media only screen and (max-width:990px){
            .box { margin: 0 0 30px; }
        }
    </style>

</head>
<body style="margin: 0;">

<%@include file="header.jsp"%>

<h1 style="text-align:center;">Clubs</h1>


<div class="grid-button" style="margin-top: 10px;">
    <button type="button" class="btn btn-success">Add</button>
</div>


<div class="grid">
    <p>${requestScope.msg}</p>
    <c:forEach var="club" items="${requestScope.clubs}">
        <div class="box">
            <form action="${pageContext.request.contextPath}/clubservlet" method="post">
                <img src="${club.image}">
                <input type="text" name="image" style="display: none;" value="${club.image}">
                <div class="box-content">
                    <h3 class="title">${club.name}</h3>
                    <input type="text" name="name" style="display: none;" value="${club.name}">

                    <span class="post">${club.description}</span>
                    <input type="text" name="description" style="display: none;" value="${club.description}">

                    <br><h5>${club.author}</h5>
                    <input type="text" name="author" style="display: none;" value="${club.author}">

                    <input type="text" name="date" style="display: none;" value="${club.date}">

                    <c:if test="${event.author == cookie.user.value}">
                        <div style="margin-top: 10px;">
                            <button type="button" class="btn btn-secondary ">Edit</button>
                            <button type="button" class="btn btn-danger ">Delete</button>
                        </div>
                    </c:if>
                </div>
                <ul class="icon">
                    <li><a href="#"><i class="fa fa-search"></i></a></li>
                    <li><a href="#"><i class="fa fa-link"></i></a></li>
                </ul>
            </form>
        </div>
    </c:forEach>
</div>

<%@include file="footer.jsp"%>

</body>
</html>




