package com.construction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.construction.dao.CartDAO;
import com.construction.dao.connection;
import com.construction.dao.inventDataAccess;
import com.construction.pojo.Cart;
import com.construction.pojo.Product;

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
		
		//HttpSession session = request.getSession();
		
		int u_id = Integer.parseInt(request.getParameter("user_id"));
		int p_id = Integer.parseInt(request.getParameter("pro_id"));
		String pname = request.getParameter("productName");
		int price = Integer.parseInt(request.getParameter("pPrice"));
		int quant = Integer.parseInt(request.getParameter("quantity"));
		int timeinhr = Integer.parseInt(request.getParameter("time"));
		int totalcost = inventDataAccess.getProductSellingPrice(price,quant,timeinhr);
		//int totalcost = Integer.parseInt(request.getParameter("totalamount"));
		
		Product product = didao.getSingleProduct(p_id);
		int actualQuantity = product.getQuantity();
		/* Cart tcart = new Cart(u_id,p_id); */
		
		if(quant>actualQuantity) {
			
			/*
			 * request.setAttribute("user_id", u_id);
			 * request.setAttribute("product_id",p_id);
			 */
			 
			request.setAttribute("errorMessage1", "Only "+actualQuantity+" items are available now");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
		else {
		Cart crt = new Cart (u_id, p_id, pname, price, quant, timeinhr, totalcost);
		
		CartDAO cdao = new CartDAO(connection.getConnection());
		
		if(cdao.saveToCart(crt))
		{
			
			request.setAttribute("errorMessage1", "Added item to the cart Successfully !");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("errorMessage1", "Item Already in cart !");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			
		}
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