package com.construction.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.construction.dao.OrderDAO;
import com.construction.dao.connection;
import com.construction.dao.inventDataAccess;
import com.construction.pojo.Order;
import com.construction.pojo.Product;

/**
 * Servlet implementation class DirectOrderServlet
 */
@WebServlet("/DirectOrderServlet")
public class DirectOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		inventDataAccess didao = new inventDataAccess(connection.getConnection());
		HttpSession session = request.getSession();
		LocalDate date=LocalDate.now();
		boolean status = false;
		int u_id = Integer.parseInt(request.getParameter("user_id"));
		int p_id = Integer.parseInt(request.getParameter("pro_id"));
		String pname = request.getParameter("productName");
		int price = Integer.parseInt(request.getParameter("pPrice"));
		int quant = Integer.parseInt(request.getParameter("quantity"));
		int timeinhr = Integer.parseInt(request.getParameter("time"));
		int totalcost = didao.getProductSellingPrice(price,quant,timeinhr);
		Product product = didao.getSingleProduct(p_id);
		int actualQuantity = product.getQuantity();
		String orderdate = String.valueOf(date);
		String delivery = "Undefined";
		String ordstatus = "Pending";
		if(quant>actualQuantity) {
			request.setAttribute("message", "Only "+actualQuantity+" items are available now");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
		else {
			
		
		int productOldQuantity = product.getQuantity();
		int productUpdatedQuantity = productOldQuantity - quant;
		didao.updateQuantityAfterOrder(p_id, productUpdatedQuantity);
		Order order = new Order(u_id,p_id,pname,quant,timeinhr,totalcost,orderdate,delivery,ordstatus);
		OrderDAO orderdao = new OrderDAO(connection.getConnection());
		status = orderdao.addOrder(order);
		if(status==true) {
			session.setAttribute("active_order", order);
			 response.sendRedirect("DirectOrderSummary.jsp");
		 }
		 else 
		 {
			 response.sendRedirect("error.jsp"); 
		 }
		}
	}

}
