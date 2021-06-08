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
            <div class="col col-7">Product Name</div>
            <div class="col col-7">Quantity</div>
            <div class="col col-7">Total Price</div>
            <div class="col col-7">Time</div>
            <div class="col col-7">ETA</div>
            <div class="col col-7">Status</div>
          </li>
          <%
          for(Order order : aorder ){
          %>
          <li class="table-row" style="margin-top: 90px; ">
            <div class="col col-1"><%= order.getOrder_id() %></div>
            <div class="col col-2"><%= order.getPro_name() %></div>
            <div class="col col-3"><%= order.getQuant() %></div>
            <div class="col col-4"><%= order.getTotalprice() %></div>
            <div class="col col-4">&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp <%= order.getTime() %></div>
            <div class="col col-4"><input style="width:120px ;" type="date"></div>
            <div class=" col col-8" style="padding-right: 8px; padding-left: 30px;">
               <p class="itext">Accept</p>
                <a href="" onclick=""><i class="fav fas fa-check-circle fa-2x"></i></a> </div>
            <div class=" col col-8" style="padding-right: 50px;"><p class="itext">Decline</p><a href="" onclick=""><i class="far fav1 fa-times-circle fa-2x"></i></a> </div>
            <%} %>
          </li>
          
</body>
</html>