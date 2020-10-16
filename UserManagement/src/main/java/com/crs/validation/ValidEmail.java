package com.crs.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Target({ FIELD, PARAMETER })
public @interface ValidEmail {
	
	String message() default "{ValidEmail.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	

}
