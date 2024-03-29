package com.crs.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String>{
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public void initialize(ValidEmail arg0) {
		
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		Pattern p = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = p.matcher(email);
		return matcher.matches();
	}

}
