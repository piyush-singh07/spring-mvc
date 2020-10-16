package com.crs.model.user;

import com.crs.validation.ValidEmail;
import com.crs.validation.ValidUserName;

public class CreateUser {
	
	private String firstname;
	private String lastname;
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
	@ValidUserName(message="UserName must be alphanumeric")
	private String username; 
	@ValidEmail(message="Email format is not valid")
	private String emailId; 
	private String roles;
	
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
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
}
