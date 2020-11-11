<%@include file="header.jsp"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginpage.css">

<div class="rggroups" style="padding-bottom: 110px; padding-top: 50px;">

    <div class="choose">
        <button id="group1" class="text-center" >Log In</button>
        <button id="group2" class="text-center" >Sign Up</button>
    </div>


    <!--SIGNIN-->
    <div class="login" id="login">
        <br>
        <div id="h1">
            <h1>Welcome back</h1>
            <p id="logerr"></p>
            <br>
            <form>
                <input class="loginp" type="email" id="logEmail" placeholder="Email Address" required autocomplete="on">
                <br>
                <br>
                <input class="loginp" type="password" id="logPass" placeholder="Password">
                <br>
                <br>
                <button class="button button-block" id="logbtn" />Log In</button>
            </form>
        </div>
    </div>


    <!--SIGNUP-->
    <div class="signup" id="signup">
        <br>
        <div id="h1">
            <h1>Sign Up for Free</h1>
            <p id="errormsg"></p>
            <br>
            <form>
                <input class="loginp" type="name" id="fnameInput" placeholder="First Name" >
                <br>
                <br>
                <input class="loginp" type="surname" id="lnameInput" placeholder="Last Name">
                <br>
                <p id="checkemail"></p>
                <input class="loginp" type="email" name="email" id="emailInput"  placeholder="Email Address" >
                <br>
                <br>
                <div style="display: flex;">
                    <input id="signupinput" class="loginp" type="password"  placeholder="Set Password">

                    <div id="Oeye" onclick="pass('o')">
                        <i class='fas fa-eye' style='margin: 11px 5px 5px 5px; font-size: 24px; cursor: pointer;'></i>
                    </div>

                    <div id="Ceye" onclick="pass('c')">
                        <i class='fas fa-eye-slash' style='margin: 11px 5px 5px 5px; font-size: 22px; cursor: pointer;'></i>
                    </div>
                </div>
                <br>
                <button class="button button-block" type="submit" id="regbtn">Get Started</button>
            </form>
        </div>
    </div>
</div>
<script>
    function pass(a) {
        if (a == 'o') {
            document.getElementById("Oeye").style.display = 'none';
            document.getElementById("Ceye").style.display = 'block';
            document.getElementById("signupinput").type = "text";
        } else {
            document.getElementById("Oeye").style.display = 'block';
            document.getElementById("Ceye").style.display = 'none';
            document.getElementById("signupinput").type = "password";
        }
    }
</script>
<%@include file="footer.jsp"%>