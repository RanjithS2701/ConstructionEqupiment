package com.construction.pojo;

public class Cart {
	public int cart_id; 
	public int user_id;
	public int pro_id;
	public String p_name;
	public int price;
	public int quantity;
	public int time;
	public int total_cost;
	
	
	
	public Cart(int cart_id, int user_id, int pro_id, String p_name, int price, int quantity, int time,
			int total_cost) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.pro_id = pro_id;
		this.p_name = p_name;
		this.price = price;
		this.quantity = quantity;
		this.time = time;
		this.total_cost = total_cost;
	}

	public Cart(int user_id, int pro_id, String p_name, int price, int quantity, int time, int total_cost) {
		super();
		this.user_id = user_id;
		this.pro_id = pro_id;
		this.p_name = p_name;
		this.price = price;
		this.quantity = quantity;
		this.time = time;
		this.total_cost = total_cost;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	
	
}