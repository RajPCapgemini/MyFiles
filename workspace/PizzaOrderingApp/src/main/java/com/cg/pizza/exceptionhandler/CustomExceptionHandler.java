package com.cg.pizza.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.pizza.exceptions.InvalidOrderException;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(InvalidOrderException.class)
	public ResponseEntity<String> handleInvalidOrderException(InvalidOrderException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
