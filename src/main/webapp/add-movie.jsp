<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Movie</title>
</head>
<body>
<h1>Add a New Movie</h1>
<form action="AddMovieServlet" method="post">
    Movie Title: <input type="text" name="title"><br>
    Release Date: <input type="date" name="releaseDate"><br>
    Genre: <input type="text" name="genre"><br>
    <input type="submit" value="Add Movie">
</form>
<br>
<a href="index.jsp">Return Home</a>
</body>
</html>