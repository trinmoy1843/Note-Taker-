<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.DataBase.Operations"%>
<%@ page import="com.Entity.Note"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>EDIT NOTE</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap 4 CDN -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<%
		int noteId = (int)request.getAttribute("noteId");
		String title = (String)request.getAttribute("noteTitle");
		System.out.println(title);
		String body = (String)request.getAttribute("noteBody");
	
	%>
	<!-- Fullscreen Flexbox Container -->
	<div class="d-flex justify-content-center align-items-center"
		style="min-height: 100vh;">
		<!-- Form -->
		<div class="card shadow " style="max-width: 400px; width: 100%;">
			<div class="card-body" style="background-color: #f1f3f5;">
				<form action="doEditNote" method="post">
					<h4 class="card-title text-center">EDIT NOTE</h4>
					<input type="hidden" name="nid" value=<%=noteId %>>
					<div class="form-group">
						<input type="text" class="form-control" name="title"
							placeholder="ADD TITLE" required value="<%= title %>">
					</div>
					<div class="form-group">
						<textarea class="form-control text-left" id="description"
							name="body" rows="6" cols="60" placeholder="ADD BODY" required><%= body %></textarea>
					</div>
						<button type="submit" class="btn btn-outline-primary btn-block">SAVE</button>					
						<a href="loadNoteHome" class="btn btn-outline-primary btn-block">RETURN TO DASHBOARD</a>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
