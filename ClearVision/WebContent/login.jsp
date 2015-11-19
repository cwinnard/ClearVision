<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>

<head>

<title>Elicit Reference Resource Organization Tool </title>
<meta charset="ISO-8859-1">

<link href='https://fonts.googleapis.com/css?family=Ubuntu+Mono:400,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type = "text/css" href="css/clearVisionCSS.css">

<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>

<body>

	<nav id="myNavbar"
		class="navbar navbar-default navbar-inverse navbar-fixed-top"
		role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>	
				</button>
				<a class="navbar-brand" href="index.html"><span id ="elicit">Elicit</span></a>
				<img alt="orange crow logo" src="images/orangeCrow.svg" id="menuCrow">
			</div>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				 <ul class="nav navbar-nav navbar-right">	
					<li><a href="index.html" target="_self">Home</a></li>
					<li><a href="getStarted.html" target="_self">Get Started</a></li>
					<li class="active"><a href="login.jsp" target="_self">Login</a></li>
					<li><a href="contactUs.jsp" target="_self">Contact Us</a></li>
				  </ul>
			</div>
		</div>
	</nav>
	
	<div class="wrapper">
		<div class="row">
			<div class="container">
				<div class="col-sm-3 col-md-4" style= "margin-top: 6em;">
			 	  <form role="form">
 				    <div class="form-group">
    				  <label for="email">Email address:</label>
    				  <input type="email" class="form-control" id="email">
 					</div>
 				    <div class="form-group">
    				  <label for="pwd">Password:</label>
    				  <input type="password" class="form-control" id="pwd">
  					</div>
  					<button type="submit" class="btn btn-default">Submit</button>
				  </form>
				</div>
			  <div class="col-sm-1 col-md-3" style= "margin-top: 4em; text-align: center;">
			    <h1 style="margin: 2em 0em 0em 0em">Or</h1>
			  </div>
			    <div class="col-sm-8 col-md-5"  style= "margin-top: 6em;">
				  <form role="form">
				  <div class="form-group">
    				  <label for="firstName">First Name:</label>
    				  <input type="text" class="form-control" id="firstName">
 					</div>
 					<div class="form-group">
    				  <label for="email">Last Name:</label>
    				  <input type="text" class="form-control" id="lastName">
 					</div>
 				    <div class="form-group">
    				  <label for="email">Email address:</label>
    				  <input type="email" class="form-control" id="email">
 					</div>
 				    <div class="form-group">
    				  <label for="pwd">Password:</label>
    				  <input type="password" class="form-control" id="pwd">
  					</div>
  					<button type="submit" class="btn btn-default">Submit</button>
				  </form>
				</div>
			</div>
		</div>
		<img alt="orange crow logo" src="images/orangeCrow.svg" id="loginCrow">
	  		<div class="push">
	  		</div>	
	</div>
	<div class="footer">
    <p><span id = "elicitFooter">Elicit</span> &copy; Copyright 2015 All Rights Reserved </p>
	</div>
	
  </body>
</html>	 


