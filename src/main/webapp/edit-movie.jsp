<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Movie</title>
</head>
<body>
<h1>Edit Movie</h1>
<form action="EditMovieServlet" method="post">
    <input type="hidden" name="id" value="${selectedMovie.id}">
    Movie Title: <input type="text" name="title" value="${selectedMovie.title}"><br>
    Release Date: <input type="date" name="releaseDate" value="${selectedMovie.releaseDate}"><br>
    <input type="submit" value="Update Movie">
</form>
<br>
<a href="index.jsp">Return Home</a>
</body>
</html>