package com.simpleBank.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameter;

import com.bankServer.exception.InsufficientFundException;
import com.bankServer.exception.InvalidAccountException;
import com.bankServer.exception.NegativeAmountException;
import com.bankServer.service.*;

public class Testing {
	BankServerService bankServerServiceImpl = new BankServerServiceImpl();
	private static int testNo=0;
	@BeforeEach
	public void beforeEach() {
		System.out.println("Testing..."+testNo++);
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("Worked as expected");
	}
	@Test
	@DisplayName("Salary Test")
	public void testSalary() {
		try {
			double expected=10000;
			double actual=bankServerServiceImpl.showBalance(10000);
			assertEquals(expected,actual);
		}catch(InvalidAccountException e) {
			System.out.println(e);
		}
	}
	
	@Test
	@DisplayName("Deposit Test")
	public void testDeposit() throws NegativeAmountException {
		try {
			double expected=10500;
			double actual=bankServerServiceImpl.deposit(10000, 500);
			assertEquals(expected,actual);
		}catch(InvalidAccountException e) {
			System.out.println(e);
		}
	}
	
	@Test
	@DisplayName("Withdraw Test")
	public void testWithdraw() throws NegativeAmountException {
		try {
			double expected=9500;
			double actual = bankServerServiceImpl.withdraw(10000, 500);
			assertEquals(expected,actual);
		}catch(InvalidAccountException e) {
	
			System.out.println(e);
		}catch(InsufficientFundException e) {
			System.out.println(e);
		}
		
	}
	
	@Test
	@DisplayName("Account Inactivity Test")
	public void testAccountInactive() {
		try {
			assertTrue(bankServerServiceImpl.isInactive(10001));
		}catch(InvalidAccountException e) {
			System.out.println(e);
		}
	}
	
	@Test
	@DisplayName("InvalidAccountException Test")
	public void testInvalidAccountException() {
		assertThrowsExactly(InvalidAccountException.class, ()-> bankServerServiceImpl.showBalance(1));
	}
	
	@Test
	@DisplayName("InsufficientFundException Test")
	public void testInsufficientFundException() {
		assertThrowsExactly(InsufficientFundException.class, ()-> bankServerServiceImpl.withdraw(10001,300000));
	}
	
	@Test
	@DisplayName("NegativeAmountException Test")
	public void testNegativeAmountExcetion() {
		assertThrowsExactly(NegativeAmountException.class,()-> bankServerServiceImpl.withdraw(10000, -90));
	}
	
}
