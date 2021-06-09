<%@ page import="com.construction.dao.OrderDAO" %>
<%@ page import="com.construction.dao.connection" %>
<%@ page import="com.construction.pojo.Order" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/order.css" type="text/css"/>
    <script src="https://kit.fontawesome.com/c6361b72de.js" crossorigin="anonymous"></script>
    <title>Order Table</title>
</head>
<body>
<%
OrderDAO orderdao = new OrderDAO(connection.getConnection());
List<Order> aorder = orderdao.getAllOrders();
%>
  <div class="container">
        
        <ul class="responsive-table" >
          <li class="table-header" >
            <div class="col col-7">Order Id</div>
            <div class="col col-7">Order Date</div>
            <div class="col col-7">User ID</div>
            <div class="col col-7">Product Name</div>
            <div class="col col-7">Quantity</div>
            <div class="col col-7">Total Price</div>
            <div class="col col-7">Time</div>
            <div class="col col-7">ETA</div>
            <div class="col col-7">Status</div>
            <div class="col col-7">Action</div>
          </li>
          <%
          for(Order order: aorder){
          %>
          <form action="UpdateOrderServlet" method="get">
          <li class="table-row" >
            <div class="col col-1"><input style="width: 10px; border: none; border-color: transparent;" name="order_id" value="<%= order.getOrder_id() %>"></div>
            <div class="col col-2"><%= order.getOrderDate() %></div>
            <div class="col col-3"><%= order.getU_id() %></div>
            <div class="col col-10"><%= order.getPro_name() %></div>
            <div class="col col-4"><%= order.getQuant() %></div>
            <div class="col col-5"><%= order.getTotalprice() %></div>
            <div class="col col-6"><%= order.getTime() %></div>
            <div class="col col-9"><input style="width:120px ;" type="date" name="delivery"></div>
            <div class=" col col-8" >
                <select name="status" id="">
                <option>PENDING</option>
                <option value="">ACCEPTED</option>
                <option value="">REJECTED</option>
            </select>
        </div>
        <div class="col col-11"><button type="submit">UPDATE</button></div>
   <%} %>
          </li>
          </form>
          
        </ul>
      </div>
</body>
</html>