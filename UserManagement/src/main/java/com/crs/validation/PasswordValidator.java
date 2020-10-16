package com.crs.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword,String> {
	
	private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	@Override
	public void initialize(ValidPassword validPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext arg1) {
		Pattern p =Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = p.matcher(password);
		return matcher.matches();
	}

}
