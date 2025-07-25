<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>HOME</title>
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
		<!-- Card -->
		<div class="card shadow " style="max-width: 400px; width: 100%;">
			<div class="card-body" style="background-color: #f1f3f5;" >
				<%
					String flag = (String)request.getAttribute("reg");
					if(flag!=null && !flag.equals("0")){
							%><p class="text-center text-success">REGISTRATION SUCCESSFULL<br>YOUR USER ID IS <%=flag%>
							<br>LOGIN TO CONTINUE</p><%
					}
					flag = (String)request.getAttribute("login");
					if(flag!=null && flag.equals("success")){
							%><p class="text-center text-success">LOGIN SUCCESSFULL</p><%
					}
				%>
				<h4 class="card-title text-center">NOTES</h4>
				<a href="loadLogin" class="btn btn-outline-primary btn-block">LOGIN</a>
				<a href="loadRegister" class="btn btn-outline-primary btn-block">REGISTER</a>
			</div>
		</div>
	</div>

</body>
</html>
