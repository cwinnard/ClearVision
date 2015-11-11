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

		<!-- Brand and toggle get grouped for better mobile display -->

		<div class="container">

			<div class="navbar-header">

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbarCollapse">

					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>

				</button>

				<a class="navbar-brand" href="#">Clear Vision</a>

			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->

			<div class="collapse navbar-collapse" id="navbarCollapse">

				<ul class="nav navbar-nav">

					<li class="active"><a href="null"
						target="_blank">Home</a></li>

					<li><a href="null"
						target="_blank">About</a></li>
						
					<li><a href="null"
						target="_blank">Get Started</a></li>

					<li><a href="null"
						target="_blank">Contact</a></li>

				</ul>

			</div>

		</div>

	</nav>

	<div class="container">

		<div class="well">
			<h1>Log in</h1>
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
	</div>
	<div class="container">

		<div class="well">
			<h1>Create account</h1>
		  <form role="form">
		  <div class="form-group">
   			  <label for="first name">First Name:</label>
   			  <input type="text" class="form-control" id="firstName">
  			</div>
  			<div class="form-group">
   			  <label for="first name">Last Name:</label>
   			  <input type="text" class="form-control" id="firstName">
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
		<hr>
	<div class="row">
		<div class="col-sm-12">
				<footer>
					<p>&copy; Copyright 2015 Clear Vision</p>
				</footer>
		</div>
	</div>
</body>
</html>
