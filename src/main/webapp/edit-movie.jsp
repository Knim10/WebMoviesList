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
    Movie Title: <input type="text" name="title" value="${movieToEdit.title}"><br>
    Release Date: <input type="date" name="releaseDate" value="${movieToEdit.releaseDate}"><br>
    Genre: <input type="text" name="genre" value="${movieToEdit.genre}"><br>
    <input type="hidden" name="id" value="${movieToEdit.id}">
    <input type="submit" value="Update Movie">
</form>
<br>
<a href="index.jsp">Return Home</a>
</body>
</html>