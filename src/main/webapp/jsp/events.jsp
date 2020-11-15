<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" type="text/css" href="Main.css">
    <link href="https://fonts.googleapis.com/css2?family=Hind&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Hammersmith+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@800&display=swap" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <style>
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

    </style>
</head>
<body style="margin: 0;">

<%@include file="header.jsp"%>


<h1 style="text-align:center;">Events</h1>
<div class="grid-button" style="margin-top: 10px;">
    <c:if test="${event.author == 'Administrator'}">
        <button type="button" class="btn btn-success">Add</button>
    </c:if>
</div>
<div class="cards">
    <c:forEach var="event" items="${requestScope.events}">
        <div class="card">
            <form action="${pageContext.request.contextPath}/eventservlet" method="post">
                <div class="card-header">
                    Featured
                </div>
                <div class="card-body">
                    <h5 class="card-title">${event.name}</h5>
                    <input type="text" name="name" style="display: none;" value="${event.name}">

                    <p class="card-text">${event.description}</p>
                    <input type="text" name="name" style="display: none;" value="${event.description}">

                    <input type="text" name="author" style="display: none;" value="${event.author}">

                    <input type="text" name="date" style="" value="${event.date}">

                    <c:if test="${event.author == cookie.user.value}">
                        <div style="margin-top: 10px;">
                            <button type="button" class="btn btn-secondary ">Edit</button>
                            <button type="button" class="btn btn-danger ">Delete</button>
                        </div>
                    </c:if>
                </div>

            </form>
        </div>
    </c:forEach>
</div>


<%@include file="footer.jsp"%>

</body>
</html>