<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
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
					String flag = (String)request.getAttribute("reg");
					if(flag!=null && flag.equals("fail")){
							%><p class="text-center text-danger">REGISTRATION UNSUCCESSFULL<br>TRY AGAIN</p><%
					}
				%>
				<form action="doRegister" method="post">
					<h4 class="card-title text-center">REGISTER</h4>
					<div class="form-group">
						<input type="text" class="form-control" name="username"
							placeholder="ENTER YOUR USERNAME" required>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="password"
							placeholder="ENTER YOUR PASSWORD" required>
					</div>
					<button type="submit" class="btn btn-outline-primary btn-block">REGISTER</button>
					<a href="loadLogin" class="btn btn-outline-primary btn-block">EXISTING USER, LOGIN</a>
					<a href="home" class="btn btn-outline-primary btn-block">HOME</a>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
