<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Book Club</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="header">
				<h1>Book Club</h1>
				<p>A place for friends to share thoughts on books.</p>
			</div>
			<div class="row">
				<div class="col reg-form">
					<h2>Register</h2>
					<form:form action="/register" method="post" modelAttribute="newUser">
						<div class="row mb-3">
							<form:label path="name" class="col-sm-3 col-form-label">Name:</form:label>
							<div class="col-sm-8">
								<form:input path="name" class="form-control"/>
							</div>
							<form:errors path="name" class="text-danger"/>
						</div>
						<div class="row mb-3">
							<form:label path="email" class="col-sm-3 col-form-label">Email:</form:label>
							<div class="col-sm-8">
								<form:input path="email" class="form-control"/>
							</div>
							<form:errors path="email" class="text-danger"/>
						</div>
						<div class="row mb-3">
							<form:label path="password" class="col-sm-3 col-form-label">Password:</form:label>
							<div class="col-sm-8">
								<form:password path="password" class="form-control"/>
							</div>
							<form:errors path="password" class="text-danger"/>
						</div>
						<div class="row mb-3">
							<form:label path="confirm" class="col-sm-3 col-form-label">Confirm pw:</form:label>
							<div class="col-sm-8">
								<form:password path="confirm" class="form-control"/>
							</div>
							<form:errors path="confirm" class="text-danger"/>
						</div>
						<button class="btn btn-primary">Submit</button>
					</form:form>
				</div>
				<div class="col login-form">
					<h2>Log in</h2>
					<form:form action="/login" method="post" modelAttribute="newLogin">
						<div class="row mb-3">
							<form:errors path="email" class="text-danger"/>
							<form:label path="email" class="col-sm-3 col-form-label">Email:</form:label>
							<div class="col-sm-8">
								<form:input path="email" class="form-control"/>
							</div>
						</div>
						<div class="row mb-3">
							<form:errors path="password" class="text-danger"/>
							<form:label path="password" class="col-sm-3 col-form-label">Password:</form:label>
							<div class="col-sm-8">
								<form:password path="password" class="form-control"/>
							</div>
						</div>
						<button class="btn btn-success">Login</button>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>