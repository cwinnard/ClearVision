<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<title>Clear Vision Sample</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type = "text/css" href="css/clearVisionCSS.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style>

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
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="nav navbar-nav">
				<li><img alt="orange crow logo" src="images/orangeCrow.svg">
				</li>
					<li class="active"><a href="http://localhost:8080/ClearVision/homepage.jsp"
						target="Homepage">Home</a></li>
					<li><a href="http://localhost:8080/ClearVision/bookmarkUpload.jsp"
						target="Get Started">Get Started</a></li>
					<li><a href="http://localhost:8080/ClearVision/userLoginForm.jsp"
						target="Login">Login</a></li>
					<li><a href="http://localhost:8080/ClearVision/about.jsp"
						target="About Us Page">About Us</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="row">
		<div class="container">
			<div class="col-sm-12 col-md-12" style= "margin-top: 80px; text-align: left">
					<h2>Hello, ${user.firstName}</h2>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="container">
			<div class="col-sm-3" style= "margin-top: 20px; text-align: center">
				<h4>Account Info</h4>
			</div>
			<div class="col-sm-3" style= "margin-top: 20px; text-align: center">
				<h4><a href = "http://localhost:8080/ClearVision/bookmarkUpload.jsp">Upload New Bookmarks</a></h4>
			</div>
			<div class="col-sm-3" style= "margin-top: 20px; text-align: center">
				<h4>Update Existing Bookmarks</h4>	
			</div>
			<div class="col-sm-3" style= "margin-top: 20px; text-align: center">
				<h4><a href = "http://localhost:8080/ClearVision/sunBurst.jsp">Enlarge Visualization</a></h4>	
			</div>
		</div>
	</div>
	
	<div class = "row" style= "margin: 0px 0px 0px 0px;">
		<div class="container">
			<div class="col-sm-12">
				<jsp:include page = "sunBurst.html"/>
			</div>
		</div>
	</div>
</body>
</html>

