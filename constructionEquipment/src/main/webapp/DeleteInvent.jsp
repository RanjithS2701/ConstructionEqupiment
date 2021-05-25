<%@page import="java.sql.*"%>
<%
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/construction","root","Ranju2000@");
	if(request.getParameter("product_id")!=null){
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		PreparedStatement pst = null;
		pst=con.prepareStatement("delete from product where product_id=?");
		pst.setInt(1, product_id);
		pst.executeUpdate();
		response.sendRedirect("invent.jsp");
		
		con.close();
	}
}catch(Exception e){
	e.printStackTrace();
}
%>
