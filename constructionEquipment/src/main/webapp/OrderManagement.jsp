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
 <nav>
        <div class="logo">
           <p>MARSS</p>
           
        </div>

                <ul>
                   <!--  <li><a href="index.jsp">HOME</a></li>
                    <li><a href="login.jsp">Log In</a></li> -->
                    <li><a href="AdminHome.jsp">Admin Dashboard</a></li>
                    

                </ul>
    </nav>
<%
OrderDAO orderdao = new OrderDAO(connection.getConnection());
List<Order> aorder = orderdao.getAllOrders();
%>
  <div class="container">
        
        <table class="responsive-table" >
          <thead class="table-header" >
          <tr>
            <th class="col col-7" style=" text-align: center ;">Order Id</th>
            <th class="col col-7">Order Date</th>
            <th class="col col-7">User ID</th>
            <th class="col col-7">Product Name</th>
            <th class="col col-7">Quantity</th>
            <th class="col col-7">Total Price</th>
            <th class="col col-7">Time</th>
            <th class="col col-7">ETA</th>
            <th class="col col-7">Status</th>
            <th class="col col-7">Current Status</th>
            <th class="col col-7">Action</th>
            </tr>
          </thead>
          <%
          for(Order order: aorder){
          %>
         <form action="UpdateOrderServlet" method="get">
          <tbody class="table-row" >
          <tr>
            <td class="col col-1"><input class="colb"  style="width: 120px; height:27px; text-align:center; border: none; " name="order_id" value="<%= order.getOrder_id() %>"></td>
            <td class="col col-1"><%= order.getOrderDate() %></td>
            <td class="col col-1"><%= order.getU_id() %></td>
            <td class="col col-1"><%= order.getPro_name() %></td>
            <td class="col col-1"><%= order.getQuant() %></td>
            <td class="col col-1"><%= order.getTotalprice() %></td>
            <td class="col col-1"><%= order.getTime() %></td>
            <td class="col col-1"><input style="width:125px ;" type="date" value="<%= order.getDelivery() %>" name="delivery"></td>
            <td class=" col col-1" >
                <select name="status" type="text">
                <option>Pending</option>
                <option>Approved</option>
                <option>Rejected</option>
                <option>Delivered</option>
                <option>Recieved</option>
                <option>Defective</option>
                <option>Completed</option>
            </select>
        </td>
        <td class="col col-1"><%= order.getStatus() %></td>
        <td class="col col-1"><button style="width: 120px; height:27px; text-align:center; border: none; background-color: #ffffff " type="submit">UPDATE</button></td>
  
   </tr>

          </tbody>
          </form>
              <%} %>
        </table>
      </div>
</body>
</html>