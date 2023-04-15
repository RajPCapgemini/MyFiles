package com.bankJPA.service;

import com.bankJPA.exception.*;
import com.bankJPA.pojos.*;

import java.util.*;

public interface BankJPAServiceInt {
	public Account addAccount(String firstName,String lastName);
	public double showBalance(int accountNo) throws InvalidAccountException;
	public double withdraw(int accountNo,double amount) throws InvalidAccountException,InsufficientFundException,NegativeAmountException, HighValueTransactionException;
	public double deposit(int accountNo,double amount) throws InvalidAccountException,NegativeAmountException, HighValueTransactionException, InsufficientFundException;
	public String fundTransfer(int senderAcc,int receiverAcc,double amount) throws InvalidAccountException, NegativeAmountException, HighValueTransactionException, InsufficientFundException;
	public List<Transaction> last10Transaction(int accountNo) throws InvalidAccountException;
	public List<Transaction> transactionWithinDate(int accountNo,Date startDate,Date endDate) throws InvalidAccountException,InvalidDateException;
	public List<Transaction> lastNTransaction(int accountNo,int n) throws InvalidAccountException;
}
