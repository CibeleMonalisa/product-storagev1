package com.compass.productstorage.settings.validation;

public class ExceptionDto {
	private int status_code;
	private String message;
//	private String field;
	

	public ExceptionDto(int status_code, String message) {
		this.status_code = status_code;
		this.message = message;
	}
	

//	public ExceptionDto(int status_code, String message, String field) {
//		super();
//		this.status_code = status_code;
//		this.message = message;
//		this.field = field;
//	}



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
