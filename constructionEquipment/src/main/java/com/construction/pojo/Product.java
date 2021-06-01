package com.construction.pojo;

import java.io.InputStream;

public class Product {
	private int product_id;
	private String pname;
	private int quantity;
	private int priceperhr;
	private InputStream pimage;
	
	
	public Product() {
		super();
	}
    
	
	public Product(String pname, int quantity, int priceperhr, InputStream pimage) {
		super();
		this.pname = pname;
		this.quantity = quantity;
		this.priceperhr = priceperhr;
		this.pimage = pimage;
	}


	public Product(int product_id, String pname, int quantity, int priceperhr) {
		super();
		this.product_id = product_id;
		this.pname = pname;
		this.quantity = quantity;
		this.priceperhr = priceperhr;
	}

	public Product(String pname, int quantity, int priceperhr) {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPriceperhr() {
		return priceperhr;
	}

	public void setPriceperhr(int priceperhr) {
		this.priceperhr = priceperhr;
	}


	public InputStream getPimage() {
		return pimage;
	}


	public void setPimage(InputStream pimage) {
		this.pimage = pimage;
	}
	
	
}
