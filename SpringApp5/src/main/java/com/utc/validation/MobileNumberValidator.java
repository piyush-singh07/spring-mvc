package com.utc.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileNumberValidator implements ConstraintValidator<IsValidMobile, String> {
	
	private static final String MOBILE_PATTERN="\\d{10}";

	@Override
	public void initialize(IsValidMobile isValidMobile) {
	
		
	}

	@Override
	public boolean isValid(String smobile, ConstraintValidatorContext arg1) {
		Pattern p= Pattern.compile(MOBILE_PATTERN);
		Matcher matcher = p.matcher(smobile);
		return matcher.matches();
	
	}

}
