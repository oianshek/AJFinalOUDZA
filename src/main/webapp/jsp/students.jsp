<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" type="text/css" href="Main.css">
    <link rel="stylesheet" type="text/css" href="Student.css.css">
    <link href="https://fonts.googleapis.com/css2?family=Hind&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Hammersmith+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@800&display=swap" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</head>
<body style="margin: 0;">

<%@include file="header.jsp"%>

<h1 style="text-align:center;">Students</h1>
<div class="grid-button" style="margin-bottom: 30px;">

    <button type="button" class="btn btn-info">Show all</button>

    <form class="form-inline my-2 my-lg-0" style="margin-bottom: 10px;">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>

</div>
<div class="search-stud" style="margin-left: 15px;">

    <form action="/action_page.php" class="row">
        <div class="col-md-3">
            <p>By major:</p>
            <input type="radio" id="SE" name="group" value="SE">
            <label for="SE">SE</label><br>
            <input type="radio" id="IT" name="group" value="IT">
            <label for="IT">IT</label><br>
            <input type="radio" id="CS" name="group" value="CS">
            <label for="CS">CS</label><br>
            <input type="radio" id="DB" name="group" value="DB 	">
            <label for="DB">DB</label>
        </div>

        <br>

        <div class="col-md-3">
            <p>By year:</p>
            <input type="radio" id="First" name="year" value="First">
            <label for="First">First</label><br>
            <input type="radio" id="Second" name="year" value="Second">
            <label for="Second">Second</label><br>
            <input type="radio" id="Third" name="year" value="Third">
            <label for="Third">Third</label><br>
        </div>
        <br>

        <div class="col-md-3">
            <p>By Group:</p>
            <label for="Group by">Write group name here:</label><br><br>
            <!-- <input type="radio" id="Group by" name="groupby" value="Group by"> -->
            <input type="text" id="Group by" name="groupby">
        </div>
    </form>
</div>

<%@include file="footer.jsp"%>

</body>
</html>