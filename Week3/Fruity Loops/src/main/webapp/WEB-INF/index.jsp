<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/css/main.css"/> <!-- I could probably make the styling look better, but I've already spent so much time on the back end and just want to finish this. -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<title>Fruit Store</title>
	</head>
	<body>
		<h1>Fruit Store</h1>
		<div class="container">
			<table class="table">
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
				<c:forEach var="fruit" items="${fruits}">
					<tr>
						<td>${fruit.name}</td>
						<td>${fruit.price}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>