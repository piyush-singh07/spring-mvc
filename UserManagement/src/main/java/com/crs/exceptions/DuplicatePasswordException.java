package com.crs.exceptions;

public class DuplicatePasswordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7767092531426663785L;

	public DuplicatePasswordException(String message)
	{
		super(message);
	}
}
