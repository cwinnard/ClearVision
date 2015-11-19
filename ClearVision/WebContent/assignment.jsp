<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>

<title>Elicit Reference Resource Organization Tool</title>
<meta charset="ISO-8859-1">

<link href='https://fonts.googleapis.com/css?family=Ubuntu+Mono:400,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/clearVisionCSS.css">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
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
				<a class="navbar-brand" href="index.html"><span id="elicit">Elicit</span></a>
				<img alt="orange crow logo" src="images/orangeCrow.svg"
					id="menuCrow">
			</div>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="index.html" target="_self">Home</a></li>
					<li><a href="getStarted.html" target="_self">Get Started</a></li>
					<li><a href="login.jsp" target="_self">Login</a></li>
					<li class="active"><a href="contactUs.jsp" target="_self">Contact
							Us</a></li>
				</ul>
			</div>
		</div>
	</nav>

<div class = "wrapper">
	<div class = "row">
	<form role="form" action="UpdateTopicAndTagsController" method="post">
		<div class="col-sm-3" style="margin-top: 6em;">
			<div class="form-group">
				<h3 style = "text-align: center">Bookmarks</h3>
				<c:forEach var="bookmark" items="${bookmarkList}">
					<c:set var="topic" value="${bookmark.topic}" />
					<c:if test="${topic.equals('General')}">
						<input type="radio" value="${bookmark.name}" name="BookmarkName">${bookmark.name} <br>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="col-sm-3" style="margin-top: 6em;">
			<div class="form-group">
				<h3 style = "text-align: center">Topics</h3>
				<input type="radio" value="Sports" name="Topic">Sports <br>
				<input type="radio" value="News" name="Topic">News <br>
				<input type="radio" value="Finance" name="Topic">Finance <br>
				<input type="radio" value="Social Media" name="Topic">Social Media<br> 
				<input type="radio" value="Coding Resources" name="Topic">Coding Resources<br>
			</div>
		</div>
		<div class="col-sm-3" style="margin-top: 6em;">
			<div class="form-group">
				<h3 style = "text-align: center">Tags</h3>
				<input type="checkbox" value="General" name="Tag">General
				<br> <input type="checkbox" value="International" name="Tag">International
				<br> <input type="checkbox" value="Local" name="Tag">Local
				<br> <input type="checkbox" value="Java" name="Tag">Java
				<br> <input type="checkbox" value="JavaScript" name="Tag">JavaScript
				<br> <input type="checkbox" value="Help" name="Tag">Help
				<br>
			</div>
		</div>
		<div class="col-sm-1" style="margin-top: 14em;">
			<button type="submit" class="btn btn-default">Save</button>
		</div>
	</form>
		<div class="col-sm-2" style="margin-top: 14em;">
			<form action = "DisplayVisualizationController" method = "post">
				<button type="submit" class="btn btn-default">Proceed to Account</button>
			</form>
		</div>
	</div>
	<div class="push"></div>
	</div>
	
	<div class="footer">
		<p>
			<span id="elicitFooter">Elicit</span> &copy; Copyright 2015 All
			Rights Reserved
		</p>
	</div>

</body>
</html>
