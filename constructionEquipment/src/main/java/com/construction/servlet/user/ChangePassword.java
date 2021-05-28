package com.construction.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.construction.dao.UserDataAccess;
import com.construction.dao.connection;
import com.construction.pojo.User;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		String uname = request.getParameter("username");
		//String currentpassword = request.getParameter("currentpassword");
		String newpassword = request.getParameter("newpassword");
		/*
		 * User user = new User(uname, currentpassword); user.setUname(uname);
		 * user.setPassword(currentpassword);
		 */
        
		User nuser = new User(uname, newpassword);
		nuser.setUname(uname);
		nuser.setPassword(newpassword);
		
		UserDataAccess userdao = new UserDataAccess(connection.getConnection());
		if(userdao.changePassword(nuser)) {
			response.sendRedirect("welcome.jsp");
		}else {
			request.setAttribute("errorMessage", "Wrong credentials!");
		}
	}

}
