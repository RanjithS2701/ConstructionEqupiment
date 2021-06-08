package com.construction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.construction.pojo.Cart;


public class CartDAO {
Connection con;
	
	
	public CartDAO(Connection con) {
		this.con = con;
	}

	public boolean saveToCart(Cart ncart) {
    	
    	boolean status = false;
		
		  if(alreadyinCart(ncart)==true) {
		 
    		PreparedStatement ps;
	    	try {
	    		
	    		
	    		ps = con.prepareStatement( "insert into cart(user_id,pro_id,p_name,price,quantity,time,total_cost) values(?,?,?,?,?,?,?)");
	    		
	    		ps.setInt(1, ncart.getUser_id());
	    		ps.setInt(2, ncart.getPro_id());
	    		ps.setString(3, ncart.getP_name());
	    		ps.setInt(4, ncart.getPrice());
	    		ps.setInt(5, ncart.getQuantity());
	    		ps.setInt(6, ncart.getTime());
	    		ps.setInt(7, ncart.getTotal_cost());
	    	    ps.executeUpdate();
	    		
	    		status = true;
	    	  
	    	}catch(Exception e) {
	    		System.out.println("file error" + e);
	    	}
	    	return status;
    		
			
			  } 
		  else {
				  return status; 
				}
			 
    	
    }
	public boolean alreadyinCart(Cart cart) {
		 boolean rstatus = false;
		 PreparedStatement pst;
		 try {
			 pst = con.prepareStatement("select * from cart where user_id=? and pro_id=?");
			 pst.setInt(1, cart.getUser_id());
			 pst.setInt(2, cart.getPro_id());
			 ResultSet rs = pst.executeQuery();
			 if(rs.next()==false) {
					rstatus=true ;
				}else {
					rstatus=false;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return rstatus;
	 }
	 
	 public List<Cart> getcartbyId(int user_id) {
		 List<Cart> cartlist = new ArrayList<>();
		 PreparedStatement pst;
		 try {
			 pst = con.prepareStatement("select * from cart where user_id=?");
			 pst.setInt(1, user_id);
			 ResultSet rs = pst.executeQuery();
			 while (rs.next()) {
				 int cart_id = rs.getInt("cart_id");
					int u_id = rs.getInt("user_id");
					int pro_id = rs.getInt("pro_id");
					String p_name = rs.getString("p_name");
					int price = rs.getInt("price");
					int quantity = rs.getInt("quantity");
					int time = rs.getInt("time");
					int total_cost = rs.getInt("total_cost");
					
					Cart dcart = new Cart(cart_id, u_id,pro_id,p_name,price,quantity,time,total_cost);
					cartlist.add(dcart);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cartlist;
		}
	 public boolean deleteCartById(int u_id){
		 boolean status=false;
	        try{
	            
	           String query= "delete from cart where user_id=?";
	           PreparedStatement pt = this.con.prepareStatement(query);
	           pt.setInt(1, u_id);
	           pt.executeUpdate();
	           status=true;
	            
	        }catch(Exception ex){
	            ex.printStackTrace();;
	        }
	        return status;
	    }
	 public Cart getcartbyUser_Id(int user_id) {
		 Cart cart = null;
		 PreparedStatement pst;
		 try {
			 pst = con.prepareStatement("select * from cart where user_id=?");
			 pst.setInt(1, user_id);
			 ResultSet rs = pst.executeQuery();
			 while (rs.next()) {
				 int cart_id = rs.getInt("cart_id");
					int u_id = rs.getInt("user_id");
					int pro_id = rs.getInt("pro_id");
					String p_name = rs.getString("p_name");
					int price = rs.getInt("price");
					int quantity = rs.getInt("quantity");
					int time = rs.getInt("time");
					int total_cost = rs.getInt("total_cost");
					
			        cart = new Cart(cart_id, u_id,pro_id,p_name,price,quantity,time,total_cost);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cart;
		}
}