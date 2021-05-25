<%@page import="java.sql.*"%>
<%
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/construction","root","Ranju2000@");
	if(request.getParameter("u_id")!=null){
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		PreparedStatement pst = null;
		pst=con.prepareStatement("delete from user where u_id=?");
		pst.setInt(1, u_id);
		pst.executeUpdate();
		response.sendRedirect("UserManage.jsp");
		
		con.close();
	}
}catch(Exception e){
	e.printStackTrace();
}
%>
