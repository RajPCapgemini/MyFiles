package com.BankJdbc.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import com.BankJdbc.exception.*;

public interface BankServiceInt {
	public double showBalance(int accountNo)throws InvalidAccountException,FileNotFoundException, IOException, SQLException;
	public double withdraw(int accountNo,double amount) throws InvalidAccountException,InsufficientFundException,NegativeAmountException,FileNotFoundException, IOException, SQLException,Exception;
	public double deposit(int accountNo,double amount) throws InvalidAccountException,NegativeAmountException,FileNotFoundException, IOException, SQLException,Exception;
	public String display(int accountNo)throws InvalidAccountException,FileNotFoundException, IOException, SQLException;
	public String displayTransactionWithinDate(int accountNo,Date startDate,Date endDate) throws InvalidAccountException,InvalidDateException,FileNotFoundException, IOException, SQLException;
	public String fundTransfer(int senderAcc,int receiverAcc,double amount)throws InvalidAccountException,InsufficientFundException,NegativeAmountException,FileNotFoundException, IOException, SQLException,Exception;
	public boolean isInactive(int accountNo) throws InvalidAccountException,FileNotFoundException, IOException, SQLException;
	public String lastNTransactions(int accountNo,int n) throws InvalidAccountException,FileNotFoundException, IOException, SQLException;
//	public void closeConnection();
}
