package com.bankJPA.exception;

public class NegativeAmountException extends Exception{
	public NegativeAmountException(String m) {
		super(m);
	}
}
