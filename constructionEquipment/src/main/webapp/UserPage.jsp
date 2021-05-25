<%@ page import="com.connection.connection"%>
<%@ page import="com.curd.product.*"%>
<%@ page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
inventDataAccess productData = new inventDataAccess(connection.getConnection());
List<Product> product = productData.getAllProducts();
request.setAttribute("PRODUCTS_LIST", product);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<style>
.card {
	/* Add shadows to create the "card" effect */
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	border-radius: 5px;
}

/* On mouse-over, add a deeper shadow */
.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

/* Add some padding inside the card container */
.container {
	padding: 2px 16px;
}
</style>
</head>
<body>
	<div class="card">
		<!-- <img src="img_avatar.png" alt="Avatar" style="width:100%"> -->
		<thread class="bg-white">
				<th scope="col">Product Id:</th>
				<br>
				<th scope="col">Product Name:</th>
				<br>
				<th scope="col">Quantity:</th>
				<br>
				<th scope="col">Price Per Hour:</th>
			
		</thread>
	   </div>	
	<div>
		<c:forEach var="tempuser" items="${PRODUCTS_LIST}">
		
				${tempuser.product_id }
				${tempuser.pname }
				${tempuser.quantity }
				${tempuser.priceperhr }
			
		</c:forEach>
  </div>
</body>
</html>