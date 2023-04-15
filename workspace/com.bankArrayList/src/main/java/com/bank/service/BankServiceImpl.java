package com.bank.service;

import com.bank.exception.*;
import com.bank.dao.*;
import com.bank.bean.*;
import java.util.*;

public class BankServiceImpl implements BankServiceInterface{
	private BankDaoInt bankDaoImpl;
	private int minimumBalance=1000;
	private static int transactionId=100000;
	public BankServiceImpl() {
		bankDaoImpl=new BankDaoImpl();
	}

	public double showBalance(int accountNo) throws InvalidAccountException {
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account==null) throw new InvalidAccountException("Account not found");
		return account.getBalance();
	}

	public double withdraw(int accountNo, double amount) throws InvalidAccountException, InsufficientFundException, NegativeAmountException{
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		if(account.getBalance()-amount<minimumBalance) throw new InsufficientFundException("Insufficient Funds");
		if(amount<0) throw new NegativeAmountException("Amount cannot be negative");
		
		ArrayList<Transaction> transactions = account.getTransactions();
		transactions.add(new Transaction(transactionId++,new Date(),"Debit",amount,account.getBalance()-amount));
		account.setBalance(account.getBalance()-amount);
		
		return account.getBalance();
	}

	public double deposit(int accountNo, double amount) throws InvalidAccountException, NegativeAmountException {
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		if(amount<0) throw new NegativeAmountException("Amount cannot be negative");
		
		ArrayList<Transaction> transactions = account.getTransactions();
		transactions.add(new Transaction(transactionId++,new Date(),"Credit",amount,account.getBalance()+amount));
		
		account.setBalance(account.getBalance()+amount);
		return account.getBalance();
	}

	public String display(int accountNo) throws InvalidAccountException {
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		
		ArrayList<Transaction> transactions = account.getTransactions();
		int count=0;
		StringBuffer tran = new StringBuffer("");
		for(int i=transactions.size()-1;count<10 && i>=0;count++,i--) {
			tran.append(transactions.get(i)+"\n");
		}
		String s=tran.toString();
		return s;
	}

	public String displayTransactionWithinDate(int accountNo, Date startDate, Date endDate) throws InvalidAccountException,InvalidDateException {
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
//		System.out.println(startDate.compareTo(endDate));
		if(startDate.compareTo(endDate)>0) {
			throw new InvalidDateException("Start date should be before than end date");
		}
		ArrayList<Transaction> transactions = account.getTransactions();
		StringBuffer sb = new StringBuffer("");
		Iterator<Transaction> itr=transactions.iterator();
		while(itr.hasNext()) {
			Transaction t = itr.next();
			if(t==null) continue;
			Calendar cal=Calendar.getInstance();
			cal.setTime(endDate);
			cal.add(Calendar.HOUR, 24);
			if(t.getDate().compareTo(startDate)>=0 && t.getDate().compareTo(cal.getTime())<0) {
				sb.append(t+"\n");
			}
		}
		String s=sb.toString();
		return s;
	}

	public String fundTransfer(int senderAcc, int receiverAcc, double amount) throws InvalidAccountException, InsufficientFundException , NegativeAmountException{
		Account accountFrom = bankDaoImpl.getByAccountNo(senderAcc);
		Account accountTo = bankDaoImpl.getByAccountNo(receiverAcc);
		if(accountFrom == null || accountTo==null) throw new InvalidAccountException("Account not found");
		if(accountFrom.getBalance()-amount<minimumBalance) throw new InsufficientFundException("Insufficient Funds");
		if(amount<0) throw new NegativeAmountException("Amount cannot be negative");
		
		withdraw(senderAcc,amount);
		deposit(receiverAcc,amount);
		String str="";
		str+="Remaining Balance in your account: "+accountFrom.getBalance();
		str+="\nRemaining Balance in receiver account: "+accountTo.getBalance();
		return str;
	}

	public boolean isInactive(int accountNo) throws InvalidAccountException {
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, -1);
		ArrayList<Transaction> transactions=account.getTransactions();
		Iterator<Transaction> itr=transactions.iterator();
		while(itr.hasNext()) {
			Transaction t=itr.next();
			if(t==null) continue;
			Date d=lastDate.getTime();
			int val=t.getDate().compareTo(d);
			if(val>=0) {
				return false;
			}
		}
		return true;
	}

	public void inactiveAccounts() {
		bankDaoImpl.inactiveAccounts();
	}

	public String lastNTransactions(int accountNo, int n) throws InvalidAccountException {
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		
		ArrayList<Transaction> transactions = account.getTransactions();
		int count=0;
		StringBuffer tran = new StringBuffer("");
		for(int i=transactions.size()-1;count<n && i>=0;count++,i--) {
			tran.append(transactions.get(i)+"\n");
		}
		String s=tran.toString();
		return s;
	}

}
