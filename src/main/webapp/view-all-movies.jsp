<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WebMoviesList</title>
</head>
<body>
<h1>Movies List</h1>
<form method="post" action="MovieNavServlet">
    <table>
        <c:forEach items="${requestScope.allMovies}" var="currentMovie">
            <tr>
                <td><input type="radio" name="id" value="${currentMovie.id}"></td>
                <td>${currentMovie.title}</td>
            </tr>
            <tr><td colspan="2">Release Date: ${currentMovie.releaseDate}</td></tr>
            <tr><td colspan="2">Genre: ${currentMovie.genre}</td></tr>
        </c:forEach>
    </table>
    <input type="submit" value="edit" name="doThisToMovie">
    <input type="submit" value="delete" name="doThisToMovie">
    <input type="submit" value="add" name="doThisToMovie">
</form>
<br>
<a href="index.jsp">Return home</a>
</body>
</html>