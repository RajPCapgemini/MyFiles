package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.bank.exception.InsufficientFundException;
import com.bank.exception.InvalidAccountException;
import com.bank.exception.NegativeAmountException;
import com.bank.service.*;

public class Testing {
	private BankServiceInterface bankServiceImpl=new BankServiceImpl();
	@Test
	@DisplayName("Test showBalance")
	public void testBalance() throws InvalidAccountException {
		double expected = 15000;
		double actual = bankServiceImpl.showBalance(10001);
		
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("Test Withdraw")
	@Order(1)
	public void testWithdraw() throws InvalidAccountException,InsufficientFundException, NegativeAmountException{
		double expected = 10000;
		double actual = bankServiceImpl.withdraw(10001, 5000);
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("Test Deposit")
	public void testDeposit() throws InvalidAccountException, NegativeAmountException {
		double expected = 15000;
		double actual = bankServiceImpl.deposit(10000, 5000);
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("Test InvalidAccountException")
	public void testInvalidAccountException(){
		assertThrowsExactly(InvalidAccountException.class,()-> bankServiceImpl.showBalance(1));
	}
	
	@Test
	@DisplayName("Test NegativeAmountException")
	public void testNegativeAmountException() {
		assertThrowsExactly(NegativeAmountException.class,()->bankServiceImpl.withdraw(10001, -90));
	}
	
	@Test
	@DisplayName("Test InsufficientFundException")
	public void testInsufficientFundException() {
		assertThrowsExactly(InsufficientFundException.class,()->{bankServiceImpl.withdraw(10000,20000);});
	}
}
