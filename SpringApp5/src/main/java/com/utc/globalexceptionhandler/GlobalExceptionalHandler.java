package com.utc.globalexceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionalHandler {

	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointer(Exception e)
	{
		return "Nullpointer";
	}
	
	@ExceptionHandler(value=ArithmeticException.class)
	public String handleAritematicPointer(Exception e)
	{
		return "Arithematic";
	}
	
	@ExceptionHandler(value=Exception.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public String handleAllException(Exception e)
	{
		return "GlobalException";
	}
	
	
	
}
