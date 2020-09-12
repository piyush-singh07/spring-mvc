package com.utc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {
	
	private String listofValidHobbies;

	@Override
	public void initialize(IsValidHobby isValidHobby) {
	this.listofValidHobbies=isValidHobby.listofValidHobbies();
		
	}

	@Override
	public boolean isValid(String shobby, ConstraintValidatorContext constraintValidatorContext) {
		if(shobby.matches(listofValidHobbies))
		
			return true;
		else
			return false;
	}

}
