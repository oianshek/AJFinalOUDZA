$(document).ready(function(){
    $("#sbtn").on("click", function (){
        event.preventDefault();
        var a = $( "#spname" ).val();
        var url = "http://localhost:8080/AJ_Final_OUDZA_war_exploded/search?&obj=" + a;

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

    ///////////////////////////////////////////////////////////
    // $("#emailInput").focus(function () {
    //     $(this).keyup(function () {
    //         $('#checkemail').addClass("bg-warning my-5");
    //         $('#checkemail').text("Loading...");
    //         $("#checkemail").removeClass('bg-danger');
    //         $("#checkemail").removeClass('bg-success');
    //     })
    // });
    ////////////////////////////////////////////////////////////

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