
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Login.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Assistant:wght@600&family=Patua+One&display=swap" rel="stylesheet">
    <script>
<%--        <%@include file="../js/javascript.js"%>--%>
    $(document).ready(function (){
        $("#logbtn").on("click", function () {
            event.preventDefault();
            $.ajax({
                url: "http://localhost:8080/AJ_Final_OUDZA_war_exploded/login?&action=check&em=" + $("#email").val() + "&p=" + $("#pass").val(),
                type: 'GET',
                success: function (data) {
                    if (data.message == "empty") {
                        $("#checkemail").removeClass('bg-success');
                        $("#checkemail").removeClass('bg-warning');
                        $("#checkemail").removeClass('bg-danger');
                        $("#checkemail").removeClass('bg-info');
                        $("#checkemail").addClass('bg-secondary p-2 text-white');
                        $("#checkemail").text("Fill all inputs");

                    } else if (data.message == "success") {
                        window.location.href = "http://localhost:8080/AJ_Final_OUDZA_war_exploded/index.jsp";

                    } else {
                        $("#checkemail").removeClass('bg-warning');
                        $("#checkemail").removeClass('bg-success');
                        $("#checkemail").removeClass('bg-info');
                        $("#checkemail").text("Error: " + data.message);
                        $("#checkemail").addClass("bg-danger p-2 text-white");

                    }
                }
            });
        });
    });
    </script>
    <title>Login AITU</title>
</head>
<body>
<div class="wrapper">
    <div class="title">Login Form</div>
    <form >
        <p id="checkemail"></p>
        <div class="field">
            <input type="text" required name="email" id="email">
            <label>Email Address</label>
        </div>
        <div class="field">
            <input type="password" required name="pass" id="pass">
            <label>Password</label>
        </div>
        <div class="field">
            <input type="submit" value="Login" id="logbtn">
        </div>
    </form>
</div>
</body>
</html>
