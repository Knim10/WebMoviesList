<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Movie Nights</title>
</head>
<body>
<form method = "post" action = "listnavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
	<td><input type="radio" name="id" value="${currentlist.id}"></td>
	<td><h2>${currentlist.listName}</h2></td></tr>
	<tr><td colspan="3">Movie Night:
	${currentlist.movieNight.hostName}</td></tr>
		<c:forEach var ="listVal" items ="${currentlist.listOfMovies}">
			<tr><td></td><td colspan="3">
				${listVal.title}, ${listVal.genre},
				</td>
			</tr>
		</c:forEach>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToList">
<input type="submit" value="delete" name="doThisToList">
<input type="submit" value="add" name="doThisToList">
</form>
<a href="addMoviesForListServlet">Create a new Movie List</a>
<a href="index.jsp">Home.</a>
</body>
</html>