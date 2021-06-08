package com.construction.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.construction.dao.CartDAO;
import com.construction.dao.OrderDAO;
import com.construction.dao.connection;
import com.construction.dao.inventDataAccess;
import com.construction.pojo.Cart;
import com.construction.pojo.Order;
import com.construction.pojo.Product;
/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private static final String pro_name = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		inventDataAccess pdao = new inventDataAccess(connection.getConnection());
		HttpSession session = request.getSession();
		LocalDate date=LocalDate.now();
		boolean status = false;
		int u_id = Integer.parseInt(request.getParameter("U_id"));
		CartDAO cartdao = new CartDAO(connection.getConnection());
		 /*Cart ocart = cartdao.getcartbyUser_Id(u_id); */
		
		List<Cart> cart = cartdao.getcartbyId(u_id); Order order = new Order();
		String orderdate = String.valueOf(date);
		  
		  for(Cart c: cart) {
		  
		  int p_id = c.getPro_id();
		  String pro_name = c.getP_name();
		  int time = c.getTime();
		  int totalprice = c.getTotal_cost();
		  Product product = pdao.getSingleProduct(p_id);
		  int productOldQuantity = product.getQuantity();
		  int productUpdatedQuantity = productOldQuantity - (c.getQuantity());
		  pdao.updateQuantityAfterOrder(p_id, productUpdatedQuantity);
		  
		  order.setU_id(u_id);
		  order.setP_id(p_id);
		  order.setPro_name(c.getP_name());
		  order.setQuant(c.getQuantity());
		  order.setTime(c.getTime());
		  order.setTotalprice(c.getTotal_cost());
		  order.setOrderDate(orderdate);
		  order.setDelivery("undefined");
		  order.setStatus("Pending");
		  
		  OrderDAO orderdao = new OrderDAO(connection.getConnection());
		  status = orderdao.addOrder(order);
		  }
		 
		/*  int p_id = ocart.getPro_id(); String pro_name = ocart.getP_name(); int quant
		  = ocart.getQuantity(); int time = ocart.getTime(); int totalprice =
		  ocart.getTotal_cost();
		 
		 
		String delivery = "Undefined";
		String status = "Pending";
		Order order = new Order(u_id, p_id, pro_name, quant, time, totalprice, orderdate, delivery, status);*/
		  
		 
		
		 if(status==true) {
			 cartdao.deleteCartById(u_id);
			 response.sendRedirect("welcome.jsp");
		 }
		 else 
		 {
			 response.sendRedirect("AddToCart.jsp"); 
		 }
		
	}		
	

	/**
	 * @param time
	 * @param totalBill
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, int time, int totalBill)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
