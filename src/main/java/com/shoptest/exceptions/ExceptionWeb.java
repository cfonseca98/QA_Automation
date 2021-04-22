package com.shoptest.exceptions;

public class ExceptionWeb extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public static final String MESSAGE_EXCEPTION_INTERACTION_FIRST_SCREEN = "----- Error ----- There is an error interacting with the interaction authentication before pass";

	public ExceptionWeb(String message) {
		super(message);
	}

	public ExceptionWeb(String message, Throwable cause) {
		super(message,cause);
	}

}
