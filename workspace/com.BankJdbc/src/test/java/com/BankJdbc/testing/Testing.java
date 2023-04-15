package com.BankJdbc.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import java.sql.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.BankJdbc.exception.*;
import com.BankJdbc.service.*;
import com.BankJdbc.util.AccountUtil;

public class Testing {
	BankServiceInt bankServiceImpl;
	void setValues() throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException, IOException {
		bankServiceImpl=new BankServiceImpl();
		AccountUtil accountUtil=new AccountUtil();
		try {
			Connection conn = accountUtil.getMyConnection();
			String query = "UPDATE account SET balance=10000 WHERE accountno=101";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.executeUpdate();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	@DisplayName("Test showBalance")
	public void testBalance() throws InvalidAccountException, FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		setValues();
		double expected = 10000;
		double actual = bankServiceImpl.showBalance(101);
		
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("Test Withdraw")
	public void testWithdraw() throws Exception{
		setValues();
		double expected = 9500;
		double actual = bankServiceImpl.withdraw(101, 500);
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("Test Deposit")
	public void testDeposit() throws Exception {
		setValues();
		double expected = 10600;
		double actual = bankServiceImpl.deposit(101, 600);
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
		assertThrowsExactly(NegativeAmountException.class,()->bankServiceImpl.withdraw(101, -90));
	}
	
	@Test
	@DisplayName("Test InsufficientFundException")
	public void testInsufficientFundException() {
		assertThrowsExactly(InsufficientFundException.class,()->{bankServiceImpl.withdraw(101,2000000);});
	}
}
