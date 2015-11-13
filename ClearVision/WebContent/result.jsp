<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload Example in JSP and Servlet - Java web application</title>
        <style>
		table, th, td {
    		border: 1px solid black;
   		    border-collapse: collapse;
		}
</style>
<link rel="stylesheet" type="text/css" href="Layout.css">
    </head>
 
    <body> 
        <div id="result">
            <h3>${requestScope["message"]}</h3>
        </div>
      
      	<form action = "UpdateTopicAndTagsController" method = "post">
			<fieldset id = "BookmarkList">
			<h3>Bookmarks</h3>
			<c:forEach var="bookmark" items="${bookmarkList}">
				<input type = "radio" value = "${bookmark.name}" name = "BookmarkName">${bookmark.name} <br>
			</c:forEach>
			</fieldset>
			<fieldset id = "TopicList">
			<h3>Topics</h3>
				<input type = "radio" value = "Sports" name = "Topic">Sports <br>
				<input type = "radio" value = "News" name = "Topic">News <br>
				<input type = "radio" value = "Finance" name = "Topic">Finance <br>
				<input type = "radio" value = "Topic4" name = "Topic">Other <br>
			</fieldset>
			<fieldset id = "TagList">
			<h3>Tags</h3>
				<input type = "checkbox" value = "Tag1" name = "Tag">Football <br>
				<input type = "checkbox" value = "Tag2" name = "Tag">News <br>
				<input type = "checkbox" value = "Tag3" name = "Tag">Banking <br>
				<input type = "checkbox" value = "Tag4" name = "Tag">Other <br>
			</fieldset>
			<input type="submit" value = "Save and continue editing">
			<input type="submit" value = "Save and exit to visualization">
			</form>
      
    </body>
</html>

