package com.construction.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.construction.dao.Dataaccess;
import com.construction.dao.connection;
import com.construction.pojo.User;





/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String phoneno = request.getParameter("phoneno");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		User user = new User(fname,lname,uname,dob,gender,phoneno,email,password);
		
		Dataaccess regUser = new Dataaccess(connection.getConnection());
		
		
		if (regUser.saveUser(user)) {
			   response.sendRedirect("login.jsp");
			} else {
			    // String errorMessage = "User Available";
			    //HttpSession regSession = request.getSession();
			    // regSession.setAttribute("RegError", errorMessage);
			    response.sendRedirect("register.jsp");
			    }

	}
	
}

