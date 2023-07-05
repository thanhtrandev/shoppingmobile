<%-- <%@page import="controller.CookieUtils"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
	>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="css/style.css"> 

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
	
<script src="https://use.fontawesome.com/e5306f616a.js"></script>
</head>
<body class="login-page">
	<%-- <jsp:include page="meta.jsp"></jsp:include> --%>
	<main class="container-fluid position-fixed login-modal h-50 ">
		<div class="row h-100">
			<div class="offset-md-3 col-md-6 login-box">
				<div class="row h-100 align-items-center">
					<div class="col-md-6 text-center py-3">
						<h3>Sign in</h3>

						<form action="LoginServlet" method="post">
							<input type="hidden" name="action" value="dologin">

							<%
							Cookie[] cookies = request.getCookies();
							String value = "";
							if (cookies != null) {
								for (Cookie retrievedCookies : cookies) {
									if (retrievedCookies.getName().equals("username")) {
								value = retrievedCookies.getValue();
									}
								}
							}
							if (value == "") {
							%>

							<input class="form-control mb-2" type="email" name="username">

							<%
							} else {
							%>
							<input class="form-control mb-2" type="email" name="username"
								value=<%=value%>>
							<%
							}
							%>

							<input class="form-control mb-2" type="password" name="password">

							<div class="form-check form-check-inline justify-content-start">
								<input type="checkbox" checked class="form-check-input"
									name="remember" value="yes"> <label
									class="form-check-label">Remember me</label>
							</div>

							<p>
								<a href="">Forgot your password?</a>
							</p>
							<input type="submit"
								class="btn btn-danger rounded-pill my-2 px-4" value="login">

							<div class="error">
								<%
								String error = (String) session.getAttribute("error");
								if (error != null) {
									out.println(error);
								}
								%>
							</div>

						</form>
					</div>

					<div class="col-md-6 bg-dark h-100">
						<div class="row h-100 align-content-center text-white px-3">
							<h2>Welcome back</h2>
							<p>To keep connect with us, please login with your personal
								info</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>