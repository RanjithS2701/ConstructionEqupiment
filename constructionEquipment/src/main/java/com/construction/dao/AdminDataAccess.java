package com.construction.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import  com.construction.pojo.Admin;

public class AdminDataAccess {
	
Connection con;
	
	
	public AdminDataAccess(Connection con) {
		this.con = con;
	}
	
public boolean saveUser(Admin admin) {
    	
    	boolean status = false;
    	
    	PreparedStatement ps;
    	try {
    		String sql = "insert into admin(aname,email,password) values(?,?,?)";
    		
    		ps = con.prepareStatement(sql);
    		
    		ps.setString(1, admin.getAname());
    		ps.setString(2, admin.getEmail());
    		ps.setString(3, admin.getPassword());
    		ps.executeUpdate();
    		status = true;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return status;
    }
    public boolean validate(Admin login) {
    	
    	boolean status = false;
    	String sql = "select * from admin where aname = ? and password=?";
    	
    	PreparedStatement ps;
    	try {
			ps = con.prepareStatement(sql);
			ps.setString(1, login.getAname());
			ps.setString(2, login.getPassword());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				status = true;
			}else {
				status=false;
			}
			//status = rs.next();
		   // System.out.println(status);
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
    	
    	return status;
    }

}
