$(document).ready(function(){
    $("#sbtn").on("click", function (){
        event.preventDefault();
        var a = $( "#spname" ).val();
        var url = "${pageContext.request.contextPath}/search?&obj=" + a;

        $.ajax({
            url: url,
            type: 'GET',  // http method
            accepts: 'application/json; charset=utf-8',
            //contentType: "application/json",
            success: function (data) {
                if(data[0].length != 0)
                {
                    $('#errrr').hide();

                    $("#sname").text(data[0].name);
                    $("#simg").attr('src', data[0].img_url);
                    $("#sauthor").attr('value', data[0].author);
                    $("#errormsg").show();
                }
                else{
                    alert("No result find");
                    $("#errrr").text("No result find");
                    $("#errormsg").hide();
                    $("#errrr").show();

                }

            },
            error: function (errorData, textStatus, errorMessage) {
                var msg = (errorData.responseJSON != null) ? errorData.responseJSON.errorMessage : '';
                $("#errormsg").text('Error: ' + msg + ', ' + errorData.status);

                $("#errormsg").show();
            }
        });
    });

    $("#emailInput").focus(function () {
        $(this).keyup(function () {
            $('#checkemail').addClass("bg-warning my-5");
            $('#checkemail').text("Loading...");
            $("#checkemail").removeClass('bg-danger');
            $("#checkemail").removeClass('bg-success');
        })
    });
    ////////////////////////////////////////////////////////////
    $("#regbtn").prop('disabled', true);
    $("#emailInput").blur(function () {
        event.preventDefault();
        $.ajax({
            url: "http://localhost:8080/sdpproject_war_exploded/register?&action=check&em=" + $("#emailInput").val(),
            type: 'GET',
            success: function (data) {
                if (data.message == "empty") {
                    $("#checkemail").removeClass('bg-success');
                    $("#checkemail").removeClass('bg-warning');
                    $("#checkemail").removeClass('bg-danger');
                    $("#checkemail").removeClass('bg-info');
                    $("#checkemail").addClass('bg-secondary p-2 text-white');
                    $("#checkemail").text("Fill email input");
                    $("#regbtn").prop('disabled', true);
                } else if (data.message == "success") {
                    $("#checkemail").removeClass('bg-warning');
                    $("#checkemail").removeClass('bg-danger');
                    $("#checkemail").removeClass('bg-info');
                    $("#checkemail").addClass('bg-success p-2 text-white');
                    $("#checkemail").text("This email is free");
                    $("#regbtn").prop('disabled', false);
                } else {
                    $("#checkemail").removeClass('bg-warning');
                    $("#checkemail").removeClass('bg-success');
                    $("#checkemail").removeClass('bg-info');
                    $("#checkemail").text("Error: " + data.message);
                    $("#checkemail").addClass("bg-danger p-2 text-white");
                    $("#regbtn").prop('disabled', true);
                }
            }
        });
    });

    $("#regbtn").on('click',function()
    {
        event.preventDefault();
        $.ajax({
            url: 'register.php',
            type: 'POST',
            data:
                {
                    fname: $("#fnameInput").val(),
                    lname: $("#lnameInput").val(),
                    email: $("#emailInput").val(),
                    password: $("#signupinput").val()
                },
            accepts: 'application/json; charset=utf-8',
            success: function(data)
            {
                if(data.message == 'success')
                {
                    $('#errormsg').text('User created. Now you can sign in');
                    $('#errormsg').addClass('bg-success text-white');
                    $('#errormsg').removeClass('bg-danger text-white');
                    $('#errormsg').removeClass('bg-warning text-white');
                }
                else
                {
                    $("#errormsg").text('Something went wrong');
                    $('#errormsg').addClass('bg-danger text-white');
                    $('#errormsg').removeClass('bg-success text-white');
                    $('#errormsg').removeClass('bg-warning text-white');
                }
            },
            error: function(){

            }
        });
    });


    $("#logbtn").click(function()
    {
        if( $('#logEmail').val().length == 0 || $('#logPass').val().length == 0)
        {
            $('#logerr').text("Fill all inputs");
            $('#logerr').addClass('bg-warning text-white');
        }
        else
        {
            event.preventDefault();
            $.ajax({
                url: 'login.php',
                type: 'POST',
                data:
                    {
                        email: $("#logEmail").val(),
                        password: $("#logPass").val()
                    },
                success: function(data)
                {
                    if(data.message == 'success')
                    {
                        window.location.href = 'mainpage.php';
                    }
                    else
                    {
                        $("#logerr").text(data.message);
                        $('#logerr').addClass('bg-danger text-white');
                    }
                }
            });
        }
    });

    var readerView = false;

    $("#group1").click(function()
    {
        if(readerView == true)
        {
            $('#group1').css('background-color', 'lightgreen');
            $('#group2').css('background-color', 'grey');
            $('.signup').slideToggle();
            $('.login').slideToggle();
            readerView = false;
        }

    });
    $("#group2").click(function()
    {
        if(readerView == false)
        {
            $('#group2').css('background-color', 'lightgreen');
            $('#group1').css('background-color', 'grey');
            $('.signup').slideToggle();
            $('.login').slideToggle();
            readerView = true;
        }

    });

});