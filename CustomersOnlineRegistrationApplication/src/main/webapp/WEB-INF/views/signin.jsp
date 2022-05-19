<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration Page</title>
<style>
Body {
	font-family: Calibri, Helvetica, sans-serif;
	background-color: aqua;
}

button {
	background-color: #4CAF50;
	width: 100%;
	color: orange;
	padding: 15px;
	margin: 10px 0px;
	border: none;
	cursor: pointer;
}

form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	margin: 8px 0;
	padding: 12px 20px;
	display: inline-block;
	border: 2px solid green;
	box-sizing: border-box;
}

button:hover {
	opacity: 0.7;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	margin: 10px 5px;
}

.container {
	padding: 25px;
	background-color: lightblue;
}
</style>
</head>
<body>
	<h1>Customer Registration</h1>
	<form action="/add" method="post" name="register">
		<div class="container">		
			<label>Name: </label> <input type="text" placeholder="Enter Name" name="username" required> 				
			<label>Surname:</label> <input type="text" placeholder="Enter Surname" name="usersurname"required>
			<label>Address: </label> <input type="text" placeholder="Enter Home Address" name="useraddress" required>
			<label>Phone: </label> <input type="text" placeholder="Enter Phone Number" name="userphone" required>
			<label>Email: </label> <input type="text" placeholder="Enter Email Address" name="useremail" required>
			<label>Password : </label> <input type="password" placeholder="Enter Password" name="userpass" required>
			<button type="submit">Sign In</button>
		</div>
	</form>
	<a href="/">Back to Home</a>
	<h1></h1>
	<a href="/login">Log In</a>
</body>
</html>