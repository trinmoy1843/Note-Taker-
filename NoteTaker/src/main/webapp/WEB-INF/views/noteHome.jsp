<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOTES</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap 4 CDN -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<%
		int userId = (int)session.getAttribute("userId");
		String username = (String)session.getAttribute("username");
	%>
	<div class="d-flex justify-content-center align-items-center"
		style="min-height: 100vh;">
		<!-- Card -->
		<div class="card shadow " style="max-width: 400px; width: 100%;">
			<div class="card-body" style="background-color: #f1f3f5;" >
				<h4 class="card-title text-center">Welcome, <%=username%></h4>
				<a href="loadAddNote" class="btn btn-outline-primary btn-block">ADD NOTE</a>
				<a href="viewAllNote" class="btn btn-outline-primary btn-block">VIEW ALL NOTES</a>
				<a href="logout" class="btn btn-outline-primary btn-block">LOGOUT</a>
			</div>
		</div>
	</div>
</body>
</html>