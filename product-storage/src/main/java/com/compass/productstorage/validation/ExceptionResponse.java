package com.compass.productstorage.validation;

public class ExceptionResponse {
	private int status_code;
	private String message;
	
	public ExceptionResponse(int status_code, String message) {
		this.status_code = status_code;
		this.message = message;
	}

	public int getStatus_code() {
		return status_code;
	}

	public String getMessage() {
		return message;
	}
	
	
	
}
