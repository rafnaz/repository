<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>

</style>
</head>
<body>

<form action="Login" method="post">
				<h1> Student Registration Form</h1>
				Enter ID: <input type="number" name="id"><br><br>
				Enter Name : <input type="text" name="Name"><br><br>
				Enter Email:<input type="email" name="Email"><br><br>
				Enter number:<input type="number" name="phone"><br><br>
				Enter Date Of Birth:<input type="date" name="date"><br><br>
				Enter Username:<input type="text" name="user"><br><br>
				Enter Password:<input type="password" name="pwd"><br><br>
						<input type="submit" value="Register">
				</form>
				<br><br>
				<a href="ViewServlet">View Students</a>
				
</body>
</html>