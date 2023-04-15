package com.cg.bank.service;

import com.cg.bank.exception.*;
import com.cg.bank.pojos.*;

import java.time.LocalDateTime;
import java.util.*;

public interface BankService {
	public Account addAccount(String firstName,String lastName) throws InvalidInputException;
	public double showBalance(int accountNo) throws InvalidAccountException;
	public double withdraw(int accountNo,double amount) throws InvalidAccountException,InsufficientFundException,NegativeAmountException, HighValueTransactionException;
	public double deposit(int accountNo,double amount) throws InvalidAccountException,NegativeAmountException, HighValueTransactionException, InsufficientFundException;
	public String fundTransfer(int senderAcc,int receiverAcc,double amount) throws InvalidAccountException, NegativeAmountException, HighValueTransactionException, InsufficientFundException;
	public List<Transaction> last10Transaction(int accountNo) throws InvalidAccountException;
	public List<Transaction> transactionWithinDate(int accountNo,LocalDateTime startDate,LocalDateTime endDate) throws InvalidAccountException,InvalidDateException;
	public List<Transaction> lastNTransaction(int accountNo,int n) throws InvalidAccountException;
	public boolean deleteAccount(int accountNo) throws InvalidAccountException;
}
