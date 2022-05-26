package com.compass.productstorage.validation;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> exceptionNoSuchElement(NoSuchElementException exception) {
		return new ResponseEntity<>(new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage()),
				HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> exceptionNoSuchElement(EntityNotFoundException exception) {
		return new ResponseEntity<>(new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage()),
				HttpStatus.NOT_FOUND);
	}
		
}