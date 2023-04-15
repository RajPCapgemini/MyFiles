package com.bank.service;

import java.util.Date;
import com.bank.exception.*;

public interface BankServiceInterface {
	public double showBalance(int accountNo)throws InvalidAccountException;
	public double withdraw(int accountNo,double amount) throws InvalidAccountException,InsufficientFundException,NegativeAmountException;
	public double deposit(int accountNo,double amount) throws InvalidAccountException,NegativeAmountException;
	public String display(int accountNo)throws InvalidAccountException;
	public String displayTransactionWithinDate(int accountNo,Date startDate,Date endDate) throws InvalidAccountException,InvalidDateException;
	public String fundTransfer(int senderAcc,int receiverAcc,double amount)throws InvalidAccountException,InsufficientFundException,NegativeAmountException;
	public boolean isInactive(int accountNo) throws InvalidAccountException;
	public void inactiveAccounts();
	public String lastNTransactions(int accountNo,int n) throws InvalidAccountException;
}
