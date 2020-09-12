package com.utc.validation;

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
@Target({ FIELD, PARAMETER })
@Constraint(validatedBy=HobbyValidator.class)
public @interface IsValidHobby {
	String message() default "Please provide a hobby from these 4 hobbies i.e., Hockey,Cricket,Volleyball,Basketball";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	String listofValidHobbies();

}
