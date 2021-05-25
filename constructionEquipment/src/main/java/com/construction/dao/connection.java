package com.construction.dao;

import java.sql.*;

public class connection {
private static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/construction","root","Ranju2000@");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }

}
