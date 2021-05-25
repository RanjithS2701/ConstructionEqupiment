package com.construction.servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.construction.dao.connection;
import com.construction.dao.inventDataAccess;
import com.construction.pojo.Product;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
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
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String pname = request.getParameter("pname");
        String quantity = request.getParameter("quantity");
        String priceperhr = request.getParameter("priceperhr");          
        
        Product product = new Product();
        product.setPname(pname);
        product.setQuantity(quantity);
        product.setPriceperhr(priceperhr);
        product.setProduct_id(product_id);
       
        inventDataAccess prodao = new inventDataAccess(connection.getConnection());
        boolean success = prodao.editProductInfo(product );
        if(success) {
        	response.sendRedirect("invent.jsp");
        }else {
        	System.out.println("error");
        }
        
	}

}
