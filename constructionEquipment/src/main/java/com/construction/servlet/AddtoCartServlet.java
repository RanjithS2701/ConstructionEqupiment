package com.construction.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.construction.dao.CartDAO;
import com.construction.dao.connection;
import com.construction.dao.inventDataAccess;

import com.construction.pojo.Cart;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/AddtoCartServlet")
public class AddtoCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddtoCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        inventDataAccess didao = new inventDataAccess(connection.getConnection());
		
		HttpSession session = request.getSession();
		
		int u_id = Integer.parseInt(request.getParameter("user_id"));
		int p_id = Integer.parseInt(request.getParameter("pro_id"));
		String pname = request.getParameter("productName");
		int price = Integer.parseInt(request.getParameter("pPrice"));
		int quant = Integer.parseInt(request.getParameter("quantity"));
		int timeinhr = Integer.parseInt(request.getParameter("time"));
		int totalcost = didao.getProductSellingPrice(price,quant,timeinhr);
		
		Cart crt = new Cart (u_id, p_id, pname, price, quant, timeinhr, totalcost);
		
		CartDAO cdao = new CartDAO(connection.getConnection());
		
		if(cdao.saveToCart(crt))
		{
			response.sendRedirect("welcome.jsp");
		}
		else
		{
			response.sendRedirect("welcome.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}