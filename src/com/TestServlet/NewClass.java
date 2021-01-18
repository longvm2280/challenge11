package com.TestServlet;

import java.io.Serializable;

public class NewClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String email;
	private String dob;
	private String gender;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
