package com.crs.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<ValidMobile, String> {
	private static final String MOBILE_PATTERN ="\\d{10}";

	@Override
	public void initialize(ValidMobile arg0) {
		
	}

	@Override
	public boolean isValid(String mobile, ConstraintValidatorContext arg1) {
		
		Pattern p = Pattern.compile(MOBILE_PATTERN);
		Matcher matcher=p.matcher(mobile);
		return matcher.matches();
	}

}
