<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>

<html lang="en" xmlns:xlink="http://www.w3.org/1999/xlink">
<head>
<meta charset="utf-8">
<title>Elicit Reference Resource Organization Tool</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type = "text/css" href="css/clearVisionCSS.css">
<link href='https://fonts.googleapis.com/css?family=Ubuntu+Mono:400,700' rel='stylesheet' type='text/css'>

<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="http://d3js.org/d3.v3.min.js"></script>

<style>

body {
  margin: auto;
  position: relative;
  width: 960px;
}

form {
  position: absolute;
  right: 10px;
  top: 10px;
}

path {
  stroke: #fff;
  fill-rule: evenodd;
}

</style>

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
					<li><a href="login.jsp" target="_self">Login</a></li>
					<li><a href="contactUs.jsp" target="_self">Contact Us</a></li>
				  </ul>
			</div>
		</div>
	</nav>
	
	
		
				<div class="col-sm-9 col-md-9" style="margin: 2em 0em 0em 0em">
					<script src="js/sunburst.js"></script> 	
				</div>
			
			  <div class="col-sm-3 col-md-3" style= "margin-top: 5em;">
				  <div class = "well" style="margin-top: 0em .5em 0em 1em">
				 	 <h2>Hello</h2><h4>${user.firstName}</h4>
				 	 <br><br>
				 	 <h4 style="margin: .25em 1em .25em 0em">Account Info</h4>
				 	 <p>${user.firstName}</p>
				 	  <p>${user.lastName}</p>
				 	   <p>${user.email}</p>
			 		<a href="bookmarkUpload.jsp" class="btn btn-warning" role="button" style="margin: .5em 0em 1em 0em">Upload Bookmarks</a>
             	  </div>
			 </div>
		
	  		<div class="push"></div>
	<div class="footer">
    <p><span id = "elicitFooter">Elicit</span> &copy; Copyright 2015 All Rights Reserved </p>
	</div>

</body>
</html>

