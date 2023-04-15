package com.bankJPA.exception;

public class InsufficientFundException extends Exception{
	public InsufficientFundException(String m) {
		super(m);
	}
}
