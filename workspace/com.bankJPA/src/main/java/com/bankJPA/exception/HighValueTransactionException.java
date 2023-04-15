package com.bankJPA.exception;

public class HighValueTransactionException extends Exception{
	public HighValueTransactionException(String m) {
		super(m);
	}
}
