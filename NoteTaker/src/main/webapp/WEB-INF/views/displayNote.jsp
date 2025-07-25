<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.Entity.Note"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALL NOTES</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap 4 CDN -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<body class="bg-light">
	<%
	List<Note> notes = (List<Note>) request.getAttribute("allnotes");
	%>
	<div class="d-flex justify-content-center align-items-center"
		style="min-height: 100vh;">
		<!-- Card -->
		<div class="card shadow " style="max-width: 600px; width: 100%;">
			<div class="card shadow"
				style="max-width: 600px; width: 100%; padding: 1rem; background-color: #f1f3f5;">

				<%
				for (Note note : notes) {
				%>
				<div class="card mb-3">
					<div class="card-body">
						<h4 class="card-title"><%=note.getTitle()%></h4>
						<p class="card-text"><%=note.getBody()%></p>
						<a href="loadEditNote?noteId=<%=note.getNid()%>" class="text-decoration-none text-dark">
      								<ion-icon name="create-outline" size="medium"></ion-icon>
      					</a>
      					<a href="deleteNote?noteId=<%=note.getNid()%>" class="text-decoration-none text-dark">
      								<ion-icon name="trash-outline"></ion-icon>
      					</a>
					</div>
				</div>
				<%
				}
				%>

				<a href="loadNoteHome" class="btn btn-outline-primary btn-block">RETURN
					TO DASHBOARD</a>
			</div>

		</div>
	</div>
</body>
</html>