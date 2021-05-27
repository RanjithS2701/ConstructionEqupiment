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
 * Servlet implementation class EditDetails
 */
@WebServlet("/EditDetails")
public class EditDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDetails() {
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
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phoneno = request.getParameter("phoneno");
        String email = request.getParameter("email");
        
        User euser = new User(u_id, fname, lname, phoneno, email);
        euser.setFname(fname);
        euser.setLname(lname);
        euser.setPhoneno(phoneno);
        euser.setEmail(email);
        euser.setU_id(u_id);
       
        UserDataAccess userdao = new UserDataAccess(connection.getConnection());
        boolean success = userdao.editUser(euser);
        if(success) {
        	request.setAttribute("Message", "Update Successfull");
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }else {
        	request.setAttribute("Message", "Update Failed ! Try again");
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
	}

	}


