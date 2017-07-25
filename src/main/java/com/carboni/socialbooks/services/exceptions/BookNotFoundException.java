package com.carboni.socialbooks.services.exceptions;

public class BookNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String msg) {
		super(msg);
	}

	public BookNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
