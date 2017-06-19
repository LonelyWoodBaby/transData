package com.transData.exception;

public class JsonTransException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JsonTransException() {
		super();
	}

	public JsonTransException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JsonTransException(String message, Throwable cause) {
		super(message, cause);
	}

	public JsonTransException(String message) {
		super(message);
	}

	public JsonTransException(Throwable cause) {
		super(cause);
	}
	
}
