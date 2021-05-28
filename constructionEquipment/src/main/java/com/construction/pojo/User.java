package com.construction.pojo;



public class User {
	private int u_id;
	private String fname;
	private String lname;
	private String uname;
	private String dob;
	private String gender;
	private String phoneno;
	private String email;
	private String password;
	private String password1;
	
	
	public User(int u_id, String fname, String lname, String uname, String dob, String gender, String phoneno,
			String email,  String password) {
		super();
		this.u_id = u_id;
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.dob = dob;
		this.gender = gender;
		this.phoneno = phoneno;
		this.email = email;
		this.password = password;
	}
	
	
	public User(String fname, String lname, String uname, String dob, String gender, String phoneno, String email,
			 String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.dob = dob;
		this.gender = gender;
		this.phoneno = phoneno;
		this.email = email;
		this.password = password;
	}

	

	public User(String uname, String password) {
		super();
		
		this.uname = uname;
		this.password = password;
	}

    
	
	public User(int u_id, String fname, String lname, String uname, String dob, String gender, String phoneno,
			String email) {
		super();
		this.u_id = u_id;
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.dob = dob;
		this.gender = gender;
		this.phoneno = phoneno;
		this.email = email;
	}

    
	
	public User(int u_id, String fname, String lname, String dob, String gender, String phoneno, String email) {
		super();
		this.u_id = u_id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.gender = gender;
		this.phoneno = phoneno;
		this.email = email;
	}
	


	public User(String fname, String lname, String dob, String gender, String phoneno, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.gender = gender;
		this.phoneno = phoneno;
		this.email = email;
	}

    
	public User(int u_id,String fname, String lname, String phoneno, String email) {
		super();
		this.u_id = u_id;
		this.fname = fname;
		this.lname = lname;
		this.phoneno = phoneno;
		this.email = email;
	}
    
	

	public User(String uname) {
		super();
		this.uname = uname;
	}


	public User(int u_id, String password) {
		super();
		this.u_id = u_id;
		this.password = password;
		
	}


	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


		
}

