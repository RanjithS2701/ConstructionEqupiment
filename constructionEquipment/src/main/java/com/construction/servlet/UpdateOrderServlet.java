package com.construction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.construction.dao.OrderDAO;
import com.construction.dao.connection;
import com.construction.pojo.Order;

/**
 * Servlet implementation class UpdateOrderServlet
 */
@WebServlet("/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		String delivery = request.getParameter("delivery");
        String status = request.getParameter("status");
        
        Order order = new Order();
        order.setDelivery(delivery);
        order.setStatus(status);
        order.setOrder_id(order_id);
       
        OrderDAO orderdao = new OrderDAO(connection.getConnection());
        boolean success = orderdao.updateOrder(order);
        if(success) {
        	response.sendRedirect("OrderManagement.jsp");
        }else {
        	System.out.println("error");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
