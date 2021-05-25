package com.construction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.construction.pojo.User;



public class UserDataAccess {
	
Connection con;
	
	
	public UserDataAccess(Connection con) {
		this.con = con;
	}
	
	//    retrieve the book details from database
    public List<User> getAllUsers(){
        List<User> user = new ArrayList<>();
        
        try{
            
            String query = "select * from user";
            PreparedStatement pt = this.con.prepareStatement(query);
            ResultSet rs = pt.executeQuery();
            
            while(rs.next()){
            	int u_id = rs.getInt("u_id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String uname = rs.getString("uname");
                String dob = rs.getString("dob");
                String gender = rs.getString("gender");
                String phoneno = rs.getString("phoneno");
                String email = rs.getString("email");
                
                User row = new User(u_id,fname,lname,uname,dob,gender,phoneno,email);
                user.add(row);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    
    
//    edit book information
    public boolean editUserInfo(User user){
        boolean status = false;
        try{
            String query = "update user set fname=?, lname=?, dob=? , gender=?, phoneno=?, email=?  where u_id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, user.getFname());
            pt.setString(2, user.getLname());
            pt.setString(3, user.getDob());
            pt.setString(4, user.getGender());
            pt.setString(5, user.getPhoneno());
            pt.setString(6, user.getEmail());
            pt.setInt(7, user.getU_id());
            
            pt.executeUpdate();
            status = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
       return status; 
    }
    
//    get single book information in edit page
    public User getSingleUser(int u_id){
        User user = null;
        
        try{
            String query = "select * from user where u_id=?";
            
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, u_id);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next()){
                int u_id1 = rs.getInt("u_id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String dob = rs.getString("dob");
                String gender = rs.getString("gender");
                String phoneno = rs.getString("phoneno");
                String email = rs.getString("email");
               
                user = new User(u_id1,fname,lname,dob,gender,phoneno,email);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

}
