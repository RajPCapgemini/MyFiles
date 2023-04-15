package com.bankServer.exception;

public class InsufficientFundException extends Exception{
	public InsufficientFundException(String message) {
		super(message);
	}
}
