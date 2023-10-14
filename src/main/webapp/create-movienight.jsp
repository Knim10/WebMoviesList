<%@ page import="java.util.List" %>
<%@ page import="model.Movie" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Create Movie Night</title>
</head>
<body>
    <h1>Create Movie Night</h1>
    
    <form action="createMovieNight" method="post">
        <label for="movieNightName">Movie Night Name:</label>
        <input type="text" id="movieNightName" name="movieNightName"><br><br>
        
        <label>Select Movies:</label><br>
<%
    List<Movie> movies = (List<Movie>) request.getAttribute("movies");
    if(movies != null){
        for(Movie movie : movies){
%>
            <input type="checkbox" id="movie_<%= movie.getId() %>" name="selectedMovies" value="<%= movie.getId() %>">
            <label for="movie_<%= movie.getId() %>"><%= movie.getTitle() %></label><br>
<%
        }
    }
%>
        <br>
        <input type="submit" value="Create Movie Night">
    </form>
</body>
</html>