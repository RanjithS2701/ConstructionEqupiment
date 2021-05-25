package com.construction.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.construction.dao.connection;
import com.construction.dao.AdminDataAccess;
import com.construction.pojo.Admin;


/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		String aname = request.getParameter("aname");
		String password = request.getParameter("password");

		Admin login = new Admin(aname, password);
		login.setAname(aname);
		login.setPassword(password);

		AdminDataAccess ldao = new AdminDataAccess(connection.getConnection());

		if (ldao.validate(login)) {
			RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");  
	        rd.forward(request,response);
			//response.sendRedirect("ListUsers.jsp");
		} else {
			request.setAttribute("errorMessage", "Wrong credentials!");
            request.getRequestDispatcher("Admin.jsp").forward(request, response);
			//response.sendRedirect("errorlogin.jsp");
		}
	}

}
