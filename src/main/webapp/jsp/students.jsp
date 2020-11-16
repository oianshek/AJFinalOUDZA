<html>
<head>
    <title>Search</title>
    <link rel="stylesheet" type="text/css" href="Main.css">
    <link rel="stylesheet" type="text/css" href="Student.css">
    <link href="https://fonts.googleapis.com/css2?family=Hind&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Hammersmith+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@800&display=swap" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        body{
            display: flex;
            flex-direction: column;

            min-height: 100vh;
        }

        footer{
            margin-top: auto;
        }
    </style>
</head>
<body style="margin: 0;">

<%@include file="header.jsp"%>

<h1 style="text-align:center;">Students</h1>

<div class="grid-button" style="margin-bottom: 30px;">


</div>

<div class="search-stud ml-2" style="margin-left: 15px;">

    <div class="col-md-3" style="margin-bottom: 10px;">
        <input class="form-control mr-sm-2" type="search" required placeholder="Search" id="searchinp" aria-label="Search">
        <br>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="search">Show all</button>
        <p id="searchmsg"></p>
    </div>
    <form class="row container mb-5">
        <div class="col-md-3">
            <input type="radio" checked id="name" name="radiobtn" value="name">
            <label for="name">By name</label>
        </div>

        <div class="col-md-3">
            <input type="radio" id="major" name="radiobtn" value="major">
            <label for="major">By major</label>
        </div>

        <div class="col-md-3">
            <input type="radio" id="course" name="radiobtn" value="course">
            <label for="course">By course</label>
        </div>

        <div class="col-md-3">
            <input type="radio" id="Group by" name="radiobtn" value="group">
            <label for="Group by">By Group</label>
        </div>
    </form>
</div>

<div id="students">
    <div class="container">
        <div class="row">
            <table class="table table-sm table-dark">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Email</th>
                    <th scope="col">Password</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Group name</th>
                    <th scope="col">Course</th>
                </tr>
                </thead>
                <tbody id="result">

                </tbody>
            </table>
        </div>
    </div>
</div>


<script>
    $(document).ready(function() {
        $("#students").hide();
        $("#search").on("click", function () {
            event.preventDefault();
            var a = $("#searchinp").val();
            var r = $("input:radio[name='radiobtn']:checked").val();

            var url = "http://localhost:8080/AJ_Final_OUDZA_war_exploded/userservlet?&obj=" + a + "&radio=" + r;

            $.ajax({
                url: url,
                type: 'GET',  // http method
                accepts: 'application/json; charset=utf-8',
                //contentType: "application/json",
                success: function (data) {
                    $("#result").html("");

                    if (data[0].length != 0) {

                        $.each(data, function (i, val) {
                            var content = '<tr>';
                            $.each(val, function (k, value) {
                                content += '<td>' + value + '</td>';

                            });
                            content += '</tr>';
                            $("#result").append(content);
                        });
                        $("#searchmsg").removeClass('bg-danger');
                        $("#searchmsg").text("");
                        //$("#errormsg").hide();
                        $("#students").show();

                    } else {
                        $("#searchmsg").addClass("bg-danger p-2 text-white");
                        $("#searchmsg").text("No result find");
                        //$("#errormsg").hide();
                        $("#searchmsg").show();

                        $("#students").hide();
                    }

                },
                error: function (errorData, textStatus, errorMessage) {
                    var msg = (errorData.responseJSON != null) ? errorData.responseJSON.errorMessage : '';
                    $("#searchmsg").text('Error: ' + msg + ', ' + errorData.status);

                    $("#searchmsg").show();

                    $("#students").hide();

                }
            });
        });

        $("#searchinp").keyup(function (){
            if($("#searchinp").val() != "")
            {
                $("#search").text("Search");
            }
            else
            {
                $("#search").text("Show all");
            }
        });
    });
</script>


<%@include file="footer.jsp"%>

</body>
</html>