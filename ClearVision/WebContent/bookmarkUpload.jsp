<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<title>Clear Vision Sample</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/clearVision.css">
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
					<li><a href="login.jsp" target="_self">Login</a></li>
					<li class="active"><a href="contactUs.jsp" target="_self">Contact Us</a></li>
				  </ul>
			</div>
		</div>
	</nav>
	
	<div class = "row">
		<div class = "container">
			<div class = "col-sm-12" style = "margin-top:80px">
				<h2>Export your bookmarks as an HTML file, then upload the file below!</h2>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="container">
			<div class="col-sm-12 col-md-12" style= "margin-top: 10px">
				<h3> Choose File to Upload </h3>
            	<form action="FileUploadHandler" method="post" enctype="multipart/form-data">
                <input type="file" name="file" id="file" />
                <input type="submit" value="Upload" name="upload" id="upload"/>
            </form>   
			</div>
		</div>
	</div>
	
	<footer class="footer">
      <div class="container">
        <p class="text-muted" style = "text-align: center">Elicit Reference Resource Organization Tool <br> &copy; Copyright 2015 Clear Vision <img alt="orange crow logo" src="images/orangeCrow.svg"></p>
      </div>
    </footer>
</body>
</html>

