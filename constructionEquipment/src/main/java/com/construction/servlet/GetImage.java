package com.construction.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.construction.dao.connection;


/**
 * Servlet implementation class GetImage
 */
@WebServlet("/GetImage")
public class GetImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String product_id=request.getParameter("product_id");
			/*ServletContext sc=getServletContext();
			Connection con=(Connection)sc.getAttribute("connDB");*/
			Connection con = connection.getConnection();
			PreparedStatement st=con.prepareStatement("select pimage from product where product_id=?");
			st.setString(1, product_id);
			ResultSet rs = st.executeQuery();
            while(rs.next()){

            	Blob image = rs.getBlob(1);
            
            	
            	byte[] imaData = image.getBytes(1, (int) image.length());
            	OutputStream output = response.getOutputStream();
            	response.setContentType("pimage");
            	output.write(imaData);
            	output.flush();
            	output.close();
            }
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in GetIamge : "+e);
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
