package com.cg.onlineshop.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(ProductDetailsNotFoundException.class)
	public ResponseEntity<String> handleProductDetailsNotFoundException(ProductDetailsNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
