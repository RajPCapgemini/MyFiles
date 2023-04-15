package com.bankServer.service;

import java.util.Date;

import com.bankServer.bean.*;
import com.bankServer.exception.*;

public interface BankServerService {
	public double showBalance(int accountNo)throws InvalidAccountException;
	public double withdraw(int accountNo,double amount) throws InvalidAccountException,InsufficientFundException,NegativeAmountException;
	public double deposit(int accountNo,double amount) throws InvalidAccountException,NegativeAmountException;
	public String display(int accountNo)throws InvalidAccountException;
	public String displayTransactionDuration(int accountNo,Date startDate,Date endDate) throws InvalidAccountException;
	public String fundTransfer(int senderAcc,int receiverAcc,double amount)throws InvalidAccountException,InsufficientFundException,NegativeAmountException;
	public boolean isInactive(int accountNo) throws InvalidAccountException;
	public void inactiveAccounts();
	public Transaction[] lastNTransactions(int accountNo,int n) throws InvalidAccountException;
}
