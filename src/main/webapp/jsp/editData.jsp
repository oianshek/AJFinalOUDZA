<%--
  Created by IntelliJ IDEA.
  User: oians
  Date: 16.11.2020
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<html lang="en" dir="ltr">
<head>
    <title>Edit</title>
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
        $(document).ready(function (){
            var val = $('.status').text();

            if(val == 'Event'){
                $('#date').attr("readonly",false);
            }else{
                $('#date').attr("readonly",true);
            }
        });
    </script>
</head>
<body>

<div class="wrapper">
    <div class="title"><span class="status"><%=request.getParameter("status")%></span>&nbsp editing Form</div>
    <%if (request.getParameter("status").equals("Club")) {%>
    <form action="<c:url value="/clubservlet"/>" method="post">
            <%}else if(request.getParameter("status").equals("Event")){%>
        <form action="<c:url value="/eventservlet"/>" method="post"><%}else{%>
            <form action="<c:url value="/newservlet"/>" method="post"><%}%>

                <div class="field">
                    <input type="text" readonly name="id" id="id" value="<%=request.getParameter("id")%>">
                    <label>ID</label>
                </div>

                <div class="field">
                    <input type="text" name="name" id="name" value="<%=request.getParameter("name")%>">
                    <label>Name</label>
                </div>

                <div class="field">
                    <input type="text" name="desc" id="desc" value="<%=request.getParameter("description")%>">
                    <label>Description</label>
                </div>

                <div class="field">
                    <input type="text" name="image" id="image" value="<%=request.getParameter("img")%>">
                    <label>Image-url</label>
                </div>

                <div class="field">
                    <input type="text" readonly name="author" value="<%=request.getParameter("author")%>">
                    <label>Author</label>
                </div>

                <div class="field">
                    <input id="date" type="text" readonly name="date" value="<%=request.getParameter("date")%>">
                    <label>Date</label>
                </div>

                <div class="field">
                    <input type="submit" name="btn" value="Update">
                </div>
            </form>
</div>

</body>
</html>


