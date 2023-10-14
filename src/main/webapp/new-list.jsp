<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Movie Night List</title>
</head>
<body>
	<form action ="createNewListServlet" method="post"> 
	List Name:
	<input type="text" name="listName">
	<br /> Movie Genre:
	<input type="text" name="genre" size="4">
	Movie Night:
	<input type="text" name="movieNight">
	<br /> Available Items:
	<br />
	<select name="allItemsToAdd" multiple size="6">
		<c:forEach items="${requestScope.allMovies}" var="currentMovie">
			<option value="${currentMovie.id}">${currentMovie.genre}|
				${currentMovie.title}</option>
		</c:forEach>
	</select>
	<br />
	<input type="submit" value="Create List and Add Items">
	</form>
	<a href="index.jsp">Home.</a>
</body>
</html>