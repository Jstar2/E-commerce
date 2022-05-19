
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Shopping Cart</title>

<style>
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

	<h1>Cart</h1>

	<h1></h1>

	<div align="left">
		<h4>Hello ${logCustomer}</h4>
	</div>

	<table class="table" style="width: 100%;" border="10px">
		<thead style="background-color: aqua;">
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Select</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${productCart}">
				<tr>
					<td><c:out value="${product.productName}" /></td>
					<td><c:out value=" £${ product.price}" /></td>
					<td><a type="button" class="btn"
						href="/removeProduct?productName=${product.productName}">Remove
							${product.productName} from cart</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<div align="right">
		<h4>Total: £${total}</h4>
	</div>

	<div align="right">
		<a type="button" class="btn"
			href="/pay?total=${total}">Pay and Check-out
		</a>
	</div>



	<div align="center">
		<h1 style="font: bold;">${paidOrNot}</h1>
	</div>

	<a href="/">Back to Home</a>

</body>
</html>