<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>
<title>Search results</title>
</head>

<body>
	<h1>Results</h1>


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
			<c:forEach var="product" items="${searchRsults}">
				<tr>
					<td><c:out value="${product.productName}" /></td>
					<td><c:out value="${product.quantity}" /></td>
					<td><c:out value="${product.description}" /></td>
					<td><c:out value=". £${product.price}" /></td>
					<td><img style="width: 100px" height="150px" alt=""
						src="<c:out value="${product.image}"  />"></td>

					<td><a type="button" class="btn"
						href="/selectProduct?barcode=${product.barcode}"> Add
							${product.productName} to cart</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="/">Back to Home</a>
</body>
</html>