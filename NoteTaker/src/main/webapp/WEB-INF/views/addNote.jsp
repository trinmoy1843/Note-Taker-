<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ADD NOTE</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap 4 CDN -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<!-- Fullscreen Flexbox Container -->
	<div class="d-flex justify-content-center align-items-center"
		style="min-height: 100vh;">
		<!-- Form -->
		<div class="card shadow " style="max-width: 400px; width: 100%;">
			<div class="card-body" style="background-color: #f1f3f5;">
				<%
					String flag = (String)request.getAttribute("add");
					if(flag!=null){
						if(flag.equals("success")) %><p class="text-center text-success">NOTE ADDED SUCCESFULLY</p><%
						else %><p class="text-center text-danger">TRY AGAIN</p><%
					}
				%>
				<form action="addNote" method="post">
					<h4 class="card-title text-center">ADD NOTE</h4>
					<div class="form-group">
						<input type="text" class="form-control" name="title"
							placeholder="ADD TITLE" required>
					</div>
					<div class="form-group">
						<textarea class="form-control text-left" id="description"
							name="body" rows="6" cols="60" placeholder="ADD BODY" required ></textarea>
					</div>
					<button type="submit" class="btn btn-outline-primary btn-block">ADD</button>
					<a href="loadNoteHome" class="btn btn-outline-primary btn-block">RETURN
						TO DASHBOARD</a>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
