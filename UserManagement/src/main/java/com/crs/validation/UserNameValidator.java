package com.crs.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameValidator implements ConstraintValidator<ValidUserName, String> {
	
	private static final String USERNAME_PATTERN ="^[a-zA-Z0-9_-]{4,15}$";

	@Override
	public void initialize(ValidUserName validUserName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext arg1) {
		Pattern p= Pattern.compile(USERNAME_PATTERN);
		Matcher matcher = p.matcher(username);
		return matcher.matches();
	}

}
