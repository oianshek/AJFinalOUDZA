<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Main.css">
    <link href="https://fonts.googleapis.com/css2?family=Hind&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Hammersmith+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@800&display=swap" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <style>
        body{
            height: 100%;
        }
        .cards {
            display: grid;
            grid-template-columns: repeat(1, 1fr);
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

        body{
            display: flex;
            flex-direction: column;

            min-height: 100vh;
        }

        footer{
            margin-top: auto;
        }

    </style>
    <title>News</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script><%@include file="/js/addScript.js"%></script>
</head>

<body class="d-flex flex-column h-100" style="margin: 0;">

<%@include file="header.jsp"%>

<s:query dataSource = "${snapshot}" var = "result">
    SELECT * FROM news;
</s:query>

<h1 style="text-align:center;">News</h1>
<div class="grid-button text-center" style="margin-top: 10px;">
    <c:if test="${cookie.user.value != null}">
        <button style="width: 20%" id="addd" type="button" class="btn btn-success">Add</button>
    </c:if>
</div>

<div class="cards mb-5">
    <div class="card add" style="display: none;">
        <div class="card-header">
            New Event
        </div>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/newservlet" method="post">
                <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <jsp:useBean id="now" class="java.util.Date" />
                <div class="form-group">
                    <label for="exampleInputEmail1">Title</label>
                    <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Title">
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" name="desc" class="form-control" id="description" placeholder="Description">
                </div>
                <div class="form-group">
                    <label for="image">Description</label>
                    <input type="text" name="image" class="form-control" id="image" placeholder="Image URL">
                </div>
                <div class="form-check">
                    <input type="text" name="date" class="form-check-input" id="date" value="<fmt:formatDate pattern = "yyyy-MM-dd"
         value = "${now}" />">
                    <label class="form-check-label" for="date">Check me out</label>
                </div>
                <button type="submit" class="mt-4 btn btn-primary" name="btn" value="Add">Add</button>
            </form>
        </div>
    </div>
    <c:forEach var="row" items="${result.rows}">
        <div class="card">
                <div class="card-header">
                    Featured
                </div>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/jsp/editData.jsp" method="post">
                        <img src="${row.image}" alt="" style="width: 300px; border-radius: 15px">
                        <h5 class="mt-3 card-title">${row.name}</h5>
                        <p class="col-8 card-text">${row.description}</p>
                        <b>
                            <p class="col-8 card-text">${row.date}</p>
                            <p class="col-8 card-text">${row.author}</p>
                        </b>


                        <input type="number" name="id" style="display: none" value="${row.id}">
                        <input type="text" name="status" style="display: none;" value="News">
                        <input type="text" name="name" style="display: none;" value="${row.name}">
                        <input type="text" name="description" style="display: none;" value="${row.description}">
                        <input type="text" name="img" style="display: none;" value="${row.image}">
                        <input type="text" name="author" style="display: none" value="${row.author}">
                        <input type="text" name="date" style="display: none" value="${row.date}">

                    <c:if test="${cookie.user.value.equals(row.author) || cookie.user.value.equals('Administrator')}">
                        <div style="margin-top: 10px;">
                            <button type="submit" class="btn btn-secondary">Edit</button>
                        </div>
                    </c:if>
                    </form>
                    <form action="<c:url value="/newservlet"/>" method="post">
                        <c:if test="${cookie.user.value.equals(row.author) || cookie.user.value.equals('Administrator')}">
                            <div style="margin-top: 10px">
                                <input type="number" name="id" style="display: none" value="${row.id}">
                                <button value="Delete" name="btn" type="submit" class="delete btn btn-danger">Delete</button>
                            </div>
                        </c:if>
                    </form>
                </div>
        </div>
    </c:forEach>
</div>

<%@include file="footer.jsp"%>

</body>
</html>