package com.compass.productstorage.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionHandler extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> allExceptionsHandler(Exception exception) {
		return new ResponseEntity<>(new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Value not found"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> notFoundExceptionHandler(NotFoundException exception) {
		return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND.value(), "The record was not found"),
				HttpStatus.NOT_FOUND);
	}

//	protected ResponseEntity<Object> argumentNotValidHandler(MethodArgumentNotValidException exception,
//			HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {
//		List<String> description = new ArrayList<>();
//		for (ObjectError error : exception.getBindingResult().getAllErrors()) {
//			description.add(error.getDefaultMessage());
//		}
//
//		ExceptionDto dto = new ExceptionDto(HttpStatus.BAD_REQUEST.value(), String.join("\n", description));
//		return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
//	}


	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ExceptionDto> handle(MethodArgumentNotValidException exception) {
		List<ExceptionDto> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ExceptionDto error = new ExceptionDto(HttpStatus.BAD_REQUEST.value(), e.getField(), message);
			dto.add(error);
		});
		return dto;
	}	

}

