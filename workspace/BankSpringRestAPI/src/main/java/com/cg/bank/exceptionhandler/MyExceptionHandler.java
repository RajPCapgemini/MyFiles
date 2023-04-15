package com.cg.bank.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.bank.exception.*;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(InvalidAccountException.class)
	public ResponseEntity<String> handleInvalidAccountException(InvalidAccountException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InsufficientFundException.class)
	public ResponseEntity<String> handleInsufficientFundException(InsufficientFundException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NegativeAmountException.class)
	public ResponseEntity<String> handleNegativeAmountException(NegativeAmountException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(HighValueTransactionException.class)
	public ResponseEntity<String> handleHighValueTransactionException(HighValueTransactionException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidDateException.class)
	public ResponseEntity<String> handleInvalidDateException(InvalidDateException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<String> handleInvalidInputException(InvalidInputException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
}
