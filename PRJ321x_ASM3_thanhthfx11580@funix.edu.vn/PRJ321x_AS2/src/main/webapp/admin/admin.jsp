<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
<link rel="stylesheet" href="../CSS/style.css">
</head>

<body class="loggedinpage">
	<div class="welcome" id="disappear">
		<p>Welcome <%= session.getAttribute("user") %></p>
	</div>
	<div class = info>
		<form name ="logoutform" action="../LogoutServlet" method="post">
			<span><%= session.getAttribute("user") %></span>
			<input class="logoutbutton" type="submit" value="Logout">
		</form>
	</div>
	<div class="loggedinleft">
		<h2>Funix Team</h2>
		<p>Dashboard</p>
		<p>Staff Manager</p>
	</div>
	
	<div class="loggedinright">
		<div class="fakeimg" style="height:200px;">fakeimg</div>
		<table>
			<caption>Member of the admin's team</caption>
			<tr>
				<th>N.O</th>
				<th>Name</th>
				<th>ID</th>
				<th>Teams</th>
			</tr>
			<tr>
				<td>01</td>
				<td>Thanh Tran</td>
				<td>FX11580</td>
				<td>FX 01</td>
			</tr>
			<tr>
				<td>02</td>
				<td>Tran Tai</td>
				<td>FX11581</td>
				<td>FX 02</td>
			</tr>
		</table>
	</div>
<script>
	window.onload = function(){
		var hide = document.getElementById('disappear');
		document.onclick = function(e){
			if(e.target.id !== 'disappear'){
				hide.style.display = 'none';
			};
		};
	};
</script>
</body>
</html>