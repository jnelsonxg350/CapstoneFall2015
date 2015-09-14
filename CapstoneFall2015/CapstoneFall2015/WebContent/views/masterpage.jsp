<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="/CapstoneFall2015/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/CapstoneFall2015/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="/CapstoneFall2015/css/site.css">
    <link rel="icon" href="../../favicon.ico">

    <title>Theme Template for Bootstrap</title>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body role="document">

    <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/CapstoneFall2015/Default">Bootstrap theme</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="/CapstoneFall2015/Default">Home</a></li>
            ${menu}
          </ul>
          ${loginbar}          
        </div><!--/.nav-collapse -->
      </div>
    </nav>

	<!-- Body content -->
    <div class="container theme-showcase" role="main">
      <div class="row">
        <div class="col-md-12">
        	${content}
         </div>
      </div>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
   <script type="text/javascript" src="/CapstoneFall2015/js/jquery.min.js"></script>
   <script type="text/javascript" src="/CapstoneFall2015/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="/CapstoneFall2015/js/validator.js"></script>
   <script type="text/javascript" src="/CapstoneFall2015/js/site.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js"></script>      
   <script src="http://cdn.jsdelivr.net/webshim/1.12.4/polyfiller.js"></script>
   
  </body>
</html>
