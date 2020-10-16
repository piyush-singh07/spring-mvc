package com.crs.model.user;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateRole {
	
	@NotEmpty(message="role can't be empty")
	private String role;
	@NotEmpty(message="description can't be empty")
	private String description;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
