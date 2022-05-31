package com.compass.productstorage.dto;

public class ExceptionDto {
	private int status_code;
	private String message;

	

	public ExceptionDto(int status_code, String message) {
		this.status_code = status_code;
		this.message = message;
	}
	
	public int getStatus_code() {
		return status_code;
	}

	public String getMessage() {
		return message;
	}
	
//	public String getField() {
//		return field;
//	}

	
	
	
}
