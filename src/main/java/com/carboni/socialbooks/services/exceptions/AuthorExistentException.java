package com.carboni.socialbooks.services.exceptions;

public class AuthorExistentException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthorExistentException(String msg) {
		super(msg);
	}

	public AuthorExistentException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
