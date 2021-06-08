package com.construction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.construction.pojo.Order;

public class OrderDAO {
	Connection con;
	
	public OrderDAO(Connection con) {
		this.con = con;
	}
	
	public boolean addOrder(Order order) {
          PreparedStatement pt;	
          boolean status = false;
          try {
        	  pt = con.prepareStatement("INSERT INTO `construction`.`order` (`U_id`, `p_id`, `pro_name`, `quant`, `time`, `totalprice`, `orderdate` , `delivery`, `status`) VALUES (?,?,?,?,?,?,?,?,?,?);");
        	  pt.setInt(1, order.getU_id());
        	  pt.setInt(2, order.getP_id());
        	  pt.setString(3, order.getPro_name());
        	  pt.setInt(4, order.getQuant());
        	  pt.setInt(5, order.getTime());
        	  pt.setInt(6, order.getTotalprice());
        	  pt.setString(7, order.getOrderDate());
        	  pt.setString(8, order.getDelivery());
        	  pt.setString(9, order.getStatus());
        	  pt.executeUpdate();
        	  status = true;
          }catch(SQLException e) {
        	  e.printStackTrace();
          }
         return status; 
	}
	
	public List<Order> getorderbyId(int U_id) {
		 List<Order> orderlist = new ArrayList<>();
		 
		 try {
			 PreparedStatement pst;
			 pst = this.con.prepareStatement("select * from construction.order where U_id=?");
			 pst.setInt(1, U_id);
			 ResultSet rs = pst.executeQuery();
			 while (rs.next()) {
				    int order_id = rs.getInt("order_id");
					int U_id1 = rs.getInt("U_id");
					int p_id = rs.getInt("p_id");
					String pro_name = rs.getString("pro_name");
					int quant = rs.getInt("quant");
					int time = rs.getInt("time");
					int totalprice = rs.getInt("totalprice");
					String orderdate = rs.getString("orderdate");
					String delivery = rs.getString("delivery");
					String status = rs.getString("status");
					
					Order dorder = new Order(order_id, U_id1, p_id, pro_name, quant, time, totalprice,orderdate, delivery, status);
					orderlist.add(dorder);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return orderlist;
		}

	
	public boolean deleteOrderById(int order_id) {
		boolean status=false;
        try{
            
           String query= "delete from order where order_id=?";
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setInt(1, order_id);
           pt.executeUpdate();
           status=true;
            
        }catch(Exception ex){
            ex.printStackTrace();;
        }
        return status;
		
	}
	public List<Order> getAllOrders(){
        List<Order> order = new ArrayList<>();
        
        try{
            
            String query = "select * from construction.order";
            PreparedStatement pt = this.con.prepareStatement(query);
            ResultSet rs = pt.executeQuery();
            
            while(rs.next()){
                int order_id = rs.getInt("order_id");
                String pro_name = rs.getString("pro_name");
                int quant = rs.getInt("quant");
                int totalprice = rs.getInt("totalprice");
                int time = rs.getInt("time");
                String delivery = rs.getString("delivery");
                String status = rs.getString("status");
                
                Order row = new Order(order_id, pro_name, quant, totalprice,time, delivery, status);
                order.add(row);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return order;
    }

}
