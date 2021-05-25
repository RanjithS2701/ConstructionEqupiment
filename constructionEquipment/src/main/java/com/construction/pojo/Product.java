package com.construction.pojo;

public class Product {
	private int product_id;
	private String pname;
	private String quantity;
	private String priceperhr;
	
	
	public Product() {
		super();
	}

	public Product(int product_id, String pname, String quantity, String priceperhr) {
		super();
		this.product_id = product_id;
		this.pname = pname;
		this.quantity = quantity;
		this.priceperhr = priceperhr;
	}

	public Product(String pname, String quantity, String priceperhr) {
		super();
		this.pname = pname;
		this.quantity = quantity;
		this.priceperhr = priceperhr;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPriceperhr() {
		return priceperhr;
	}

	public void setPriceperhr(String priceperhr) {
		this.priceperhr = priceperhr;
	}
	
	
}
