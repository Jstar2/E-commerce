<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
<title>Home Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
* {
	box-sizing: border-box;
}

body {
	margin: 20px;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: aqua;
}

.topnav .search-container {
	float: right;
}

.topnav input[type=text] {
	padding: 6px;
	margin-top: 8px;
	font-size: 17px;
	border: thick;
}

.topnav .search-container button {
	float: right;
	padding: 6px;
	margin-top: 8px;
	margin-right: 16px;
	background: #ddd;
	font-size: 17px;
	border: thick;
	cursor: pointer;
}

.topnav .search-container button:hover {
	background: #ccc;
}

@media screen and (max-width: 600px) {
	.topnav .search-container {
		float: none;
	}
	.topnav a, .topnav input[type=text], .topnav .search-container button {
		float: none;
		display: block;
		text-align: left;
		width: 100%;
		margin: 0;
		padding: 14px;
		broder: "thick";
	}
	.topnav input[type=text] {
		border: 3px solid #ccc;
	}
}

.btn {
	background-color: #f4511e;
	border: none;
	color: white;
	padding: 16px 32px;
	text-align: center;
	font-size: 16px;
	margin: 4px 2px;
	opacity: 0.6;
	transition: 0.3s;
	display: inline-block;
	text-decoration: none;
	cursor: pointer;
}

.btn:hover {
	opacity: 1
}
</style>
</head>


<body>
	<div class="topnav">
		<div class="search-container">

			<form action="sear" method="post">
				<input type="text" placeholder="Product Name...." name="input"
					id="sear">
				<button type="submit">Search</button>
			</form>
		</div>
	</div>

	<a href="/cart"><img
		src="https://www.freepnglogos.com/uploads/shopping-cart-png/shopping-cart-gifs-animations-shopping-cart-clipart-29.png"
		style="float: right" width="40px" height="40px"> </a>

	<form action="logout">
		<button type="submit" style="float: top; font: bold">LogOut</button>
	</form>

	<div align="left">
		<h4>Hello ${logCustomer}</h4>
	</div>

	<div style="padding-left: 16px" align="center">
		<h1>Tree House garden center</h1>
	</div>

	<a href="/">Refresh Page here</a>
	
	<h1></h1>
	<table class="table" style="width: 100%;" border="10px">
		<thead style="background-color: aqua;">
			<tr>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Description</th>
				<th>Price</th>
				<th>Image</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${products}">
				<tr>
					<td><c:out value="${product.productName}" /></td>
					<td><c:out value="${product.quantity}" /></td>
					<td><c:out value="${product.description}" /></td>
					<td><c:out value=". £${product.price}" /></td>
					<td><img style="width: 100px" height="150px" alt=""
						src="<c:out value="${product.image}"  />"></td>

					<td><a type="button" class="btn"
						href="/selectProduct?barcode=${product.barcode}">Select
							${product.productName} to cart</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<h1></h1>
	<a href="/login">Log In</a>
	<h6></h6>
	<a href="/signin">Sign In</a>

</body>
</html>