package com.construction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.construction.pojo.User;

public class Dataaccess {
	Connection con;
	
	
	public Dataaccess(Connection con) {
		this.con = con;
	}
	
    public boolean saveUser(User nuser) {
    	
    	boolean status = false;
    	
    	PreparedStatement ps;
    	try {
    		
    		
    		ps = con.prepareStatement( "insert into user(fname,lname,uname,dob,gender,phoneno,email,password) values(?,?,?,?,?,?,?,?)");
    		
    		ps.setString(1, nuser.getFname());
    		ps.setString(2, nuser.getLname());
    		ps.setString(3, nuser.getUname());
    		ps.setString(4, nuser.getDob());
    		ps.setString(5, nuser.getGender());
    		ps.setString(6, nuser.getPhoneno());
    		ps.setString(7, nuser.getEmail());
    		ps.setString(8, nuser.getPassword());
    	    ps.executeUpdate();
    		
    		status = true;
    	  
    	}catch(Exception e) {
    		System.out.println("file error" + e);
    	}
    	return status;
    }
    public boolean validate(User login) {
    	
    	boolean status = false;
    	String sql = "select * from user where uname = ? and password=?";
    	
    	PreparedStatement ps;
    	try {
			ps = con.prepareStatement(sql);
			ps.setString(1, login.getUname());
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
