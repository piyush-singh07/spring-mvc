package com.crs.exceptions;

public class PasswordMismatchException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8013277073450146764L;

	public PasswordMismatchException(String message)
	{
		super(message);
	}

}
