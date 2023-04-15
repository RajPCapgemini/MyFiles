package com.bankJPA.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.bankJPA.exception.HighValueTransactionException;
import com.bankJPA.exception.InsufficientFundException;
import com.bankJPA.exception.InvalidAccountException;
import com.bankJPA.exception.NegativeAmountException;
import com.bankJPA.service.*;

public class Testing {
	private BankJPAServiceInt bankService = new BankJPAServiceImpl();
	
	@Test
	@DisplayName("Test Balance")
	public void testShowBalance() throws InvalidAccountException {
		double expected = 9500;
		double actual = bankService.showBalance(1);
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("Test Withdraw")
	public void withdraw() throws InvalidAccountException, InsufficientFundException, NegativeAmountException, HighValueTransactionException {
		double expected = 9500;
		double actual = bankService.withdraw(152,500);
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("Test Deposit")
	public void deposit() throws InvalidAccountException, NegativeAmountException, HighValueTransactionException, InsufficientFundException {
		double expected = 10500;
		double actual = bankService.deposit(153, 500);
		assertEquals(expected,actual);
	}
}
