package com.crs.model.creation;

import org.hibernate.validator.constraints.NotBlank;

import com.crs.validation.ValidPassword;
import com.crs.validation.ValidUserName;

public class UpdatePassword {
	@ValidUserName(message="User Name must be alphamuneric")
	private String username;
	@NotBlank(message="Password Field must not be blank")
	private String oldPassword;
	@ValidPassword(message="Password should contain atleast one number ,"
			+ "one char capital,one char small,one special char (@#$%) and length between 6-20")
	private String newPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	
	

}
