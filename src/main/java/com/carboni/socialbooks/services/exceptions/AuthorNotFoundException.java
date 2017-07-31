package com.carboni.socialbooks.services.exceptions;

public class AuthorNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthorNotFoundException(String msg) {
		super(msg);
	}

	public AuthorNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
