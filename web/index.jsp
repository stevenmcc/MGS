<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <jsp:include page="jsp/header.jsp" />
        <script type="text/JavaScript" src="../js/user.js"></script>

    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <!-- This code is taken from http://twitter.github.com/bootstrap/examples/hero.html -->

        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#brand">MG Safety Services</a>
                    <div class="nav-collapse collapse">
                        <ul id="navi" class="nav">
                            <li class="active"><a href="#home">Home</a></li>
                            <li><a href="#about">About</a></li>
                            <li><a href="#contact">Contact</a></li>
                            <li><a href="#sign_up">Sign up</a></li>
                        </ul>
                        <form id="login" class="navbar-form pull-right">
                            <input class="span2" type="text" name="username" placeholder="Username">
                            <input class="span2" type="password" name="password" placeholder="Password">
                            <button id="loginbutton" type="submit" class="btn">Sign in</button>
                        </form>
                    </div><!--/.nav-collapse -->
                    <!-- Main hero unit for a primary marketing message or call to action -->

                </div>
            </div>
        </div>
        <div class="container">
        <div id="failure" class="alert alert-error">
            <strong>Error:</strong><button type="button" id="errorclose" class="close">&times;</button>
            <div id="errordetails"></div>

        </div>
        <div class="container">




        <div class="container">

            <div id="content-container"  class="hero-unit">


            </div>

            <footer>

                <p>&copy; Company 2012</p>
            </footer>

        </div> <!-- /container -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>



        <script>
            var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
            (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
            g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
            s.parentNode.insertBefore(g,s)}(document,'script'));
        </script>
    </body>
</html>
