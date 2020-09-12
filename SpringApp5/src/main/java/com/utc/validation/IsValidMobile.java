package com.utc.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Retention(RUNTIME)
@Target({ FIELD, PARAMETER })
@Constraint(validatedBy = MobileNumberValidator.class)
@Documented
public @interface IsValidMobile {
	String message() default "Mobile number must be 10 digits.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	

}
