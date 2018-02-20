<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "editArtworkItemServlet" method= "post">
	Title: <input type = "text" name = "title" value = "${artworkToEdit.title }">
	Artist Name: <input type = "text" name = "artistName" value = "${artworkToEdit.artistName }">
	Media: <input type = "text" name = "media" value = "${artworkToEdit.media }">
	Year: <input type = "text" name = "year" value = "${artworkToEdit.year }">
	Value: <input type = "text" name = "value" value = "${artworkToEdit.value }">
	<input type = "hidden" name = "id" value="${artworkToEdit.id }">
	<input type = "submit" value="Save Edited Artwork">
	</form>
</body>
</html>