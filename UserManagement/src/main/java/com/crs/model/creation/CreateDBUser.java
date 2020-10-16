package com.crs.model.creation;

import com.crs.validation.ValidEmail;
import com.crs.validation.ValidPassword;
import com.crs.validation.ValidUserName;

public class CreateDBUser {
	
	@ValidUserName(message="UserName must be alphanumeric")
	private String username;
	@ValidEmail(message="Email format is not valid")
	private String emailId;
	private String firstname;
	private String lastname;
	@ValidPassword(message="Password should contain atleast one number ,"
			+ "one char capital,one char small,one special char (@#$%) and length between 6-20")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
