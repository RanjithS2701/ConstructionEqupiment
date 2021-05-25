package com.construction.pojo;

public class Admin {
	
	private String aname;
	private String email;
	private String password;
	
	
	
	public Admin(String password, String aname) {
		super();
		this.aname = aname;
		this.password = password;
	}
	
	
	public Admin(String aname, String email, String password) {
		super();
		this.aname = aname;
		this.email = email;
		this.password = password;
	}


	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
