package com.compass.productstorage.validation;

import java.util.NoSuchElementException;

//import javax.persistence.EntityNotFoundException;
//import javax.validation.UnexpectedTypeException;
//
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
////	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
////	@ExceptionHandler(NoSuchElementException.class)
////	public ResponseEntity<Object> exceptionNoSuchElement(NoSuchElementException exception) {
////		return new ResponseEntity<>(new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage()),
////				HttpStatus.INTERNAL_SERVER_ERROR);
////	}
//	
//	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public ResponseEntity<Object> dataIntegrityViolationException(DataIntegrityViolationException exception) {
//		return new ResponseEntity<>(new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage()),
//				HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
//	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
//	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//	public ResponseEntity<Object> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
//		return new ResponseEntity<>(new ExceptionDto(HttpStatus.METHOD_NOT_ALLOWED.value(), exception.getMessage()),
//				HttpStatus.METHOD_NOT_ALLOWED);
//	}
//
//	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(EntityNotFoundException.class)
//	public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException exception) {
//		return new ResponseEntity<>(new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getLocalizedMessage()),
//				HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
//	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(UnexpectedTypeException.class)
//	public ResponseEntity<Object> unexpectedTypeException(UnexpectedTypeException exception) {
//		return new ResponseEntity<>(new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getLocalizedMessage()),
//				HttpStatus.INTERNAL_SERVER_ERROR);
//	}	
//		
//}