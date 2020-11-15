<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" type="text/css" href="Main.css">
    <link href="https://fonts.googleapis.com/css2?family=Hind&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Hammersmith+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <style>
        .grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(480px, 1fr));
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
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="Main.html"><img src="images/logo.png" style="width: 150px;height: 75px;"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="Clubs.html" style="text-align: center;">Clubs <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Events.html" style="text-align: center;">Events</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="News.html" style="text-align: center;">News</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Students.html" style="text-align: center;">Students</a>
                </li>
            </ul>
        </div>
        <div class="login-logup" style="float: right;">
            <div class="login-logup" style="float: right;">
                <a href="Login.html"><button type="button" class="btn btn-success">Sign In</button></a>
                <a href="Registration.html"><button type="button" class="btn btn-danger">Sign Up</button></a>
            </div>
        </div>
    </nav>
</header>



<h1 style="text-align:center;">Clubs</h1>


<div class="grid-button" style="margin-top: 10px;">
    <button type="button" class="btn btn-info">Show</button>
    <button type="button" class="btn btn-success">Add</button>
</div>


<div class="grid">
    <div class="box">
        <img src="images/img-1.jpg">
        <div class="box-content">
            <h3 class="title">Williamson</h3>
            <span class="post">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Expedita sapiente sint, nulla, nihil
                    repudiandae commodi voluptatibus corrupti animi sequi aliquid magnam debitis, maxime quam recusandae
                    harum esse fugiat. Itaque, culpa?</span>
            <div style="margin-top: 10px;">
                <button type="button" class="btn btn-secondary">Edit</button>
                <button type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
        <ul class="icon">
            <li><a href="#"><i class="fa fa-search"></i></a></li>
            <li><a href="#"><i class="fa fa-link"></i></a></li>
        </ul>
    </div>
    <div class="box">
        <img src="images/img-2.jpg">
        <div class="box-content">
            <h3 class="title">Miranda Roy</h3>
            <span class="post">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Expedita sapiente sint, nulla, nihil
                    repudiandae commodi voluptatibus corrupti animi sequi aliquid magnam debitis, maxime quam recusandae
                    harum esse fugiat. Itaque, culpa?</span>
            <div style="margin-top: 10px;">
                <button type="button" class="btn btn-secondary">Edit</button>
                <button type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
        <ul class="icon">
            <li><a href="#"><i class="fa fa-search"></i></a></li>
            <li><a href="#"><i class="fa fa-link"></i></a></li>
        </ul>
    </div>
    <div class="box">
        <img src="images/img-3.jpg">
        <div class="box-content">
            <h3 class="title">Miranda Roy</h3>
            <span class="post">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Expedita sapiente sint, nulla, nihil
                        repudiandae commodi voluptatibus corrupti animi sequi aliquid magnam debitis, maxime quam recusandae
                        harum esse fugiat. Itaque, culpa?</span>
            <div style="margin-top: 10px;">
                <button type="button" class="btn btn-secondary">Edit</button>
                <button type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
        <ul class="icon">
            <li><a href="#"><i class="fa fa-search"></i></a></li>
            <li><a href="#"><i class="fa fa-link"></i></a></li>
        </ul>
    </div>
</div>









</body>
</html>




