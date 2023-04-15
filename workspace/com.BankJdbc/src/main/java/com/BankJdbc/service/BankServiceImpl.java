package com.BankJdbc.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import com.BankJdbc.bean.*;
import com.BankJdbc.dao.*;
import com.BankJdbc.exception.*;


public class BankServiceImpl implements BankServiceInt{
	private BankDaoInt bankDaoImpl;
	private int minimumBalance=1000;
	public BankServiceImpl() throws ClassNotFoundException, SQLException,NullPointerException, FileNotFoundException, IOException {
		bankDaoImpl=new BankDaoImpl();
	}

	public double showBalance(int accountNo) throws InvalidAccountException, FileNotFoundException, IOException, SQLException {
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account==null) throw new InvalidAccountException("Account not found");
		return account.getBalance();
	}

	public double withdraw(int accountNo, double amount) throws Exception{
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		if(account.getBalance()-amount<minimumBalance) throw new InsufficientFundException("Insufficient Funds");
		if(amount<0) throw new NegativeAmountException("Amount cannot be negative");
		account.setBalance(account.getBalance()-amount);
		Transaction transaction = new Transaction(bankDaoImpl.getTransactionId(),new Date(),"Debit",amount,account.getBalance());
		List<Transaction> newTransactions= account.getTransactions();
		newTransactions.add(transaction);
		account.setTransactions(newTransactions);
		bankDaoImpl.save(account);
		
		return account.getBalance();
	}

	public double deposit(int accountNo, double amount) throws Exception {
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		if(amount<0) throw new NegativeAmountException("Amount cannot be negative");
		account.setBalance(account.getBalance()+amount);
		Transaction transaction = new Transaction(bankDaoImpl.getTransactionId(),new Date(),"Credit",amount,account.getBalance());
		List<Transaction> newTransactions= account.getTransactions();
		newTransactions.add(transaction);
		account.setTransactions(newTransactions);
		bankDaoImpl.save(account);
		return account.getBalance();
	}

	public String display(int accountNo) throws InvalidAccountException, FileNotFoundException, IOException, SQLException {
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		
		List<Transaction> transactions = account.getTransactions();
		if(transactions.size()==0) return "No transactions found";
		int count=0;
		StringBuffer tran = new StringBuffer("");
		for(int i=transactions.size()-1;count<10 && i>=0;count++,i--) {
			Transaction currTransaction = transactions.get(i);
			int tid=currTransaction.getTransactionId();
			String ttype=currTransaction.getTransactionType();
			Date date = currTransaction.getDate();
			Double bal = currTransaction.getBalance();
			Double amt = currTransaction.getAmount();
			tran.append("Id: "+tid+"--"+ttype+" of amount  Rs "+amt+" on "+date+". Balance: Rs "+bal+"\n");
		}
		String s=tran.toString();
		return s;
	}

	public String displayTransactionWithinDate(int accountNo, Date startDate, Date endDate) throws InvalidAccountException,InvalidDateException, FileNotFoundException, IOException, SQLException {
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		if(startDate.compareTo(endDate)>0) {
			throw new InvalidDateException("Start date should be before than end date");
		}
		List<Transaction> transactions = account.getTransactions();
		if(transactions.size()==0) return "No transactions found";
		StringBuffer sb = new StringBuffer("");
		Iterator<Transaction> itr=transactions.iterator();
		while(itr.hasNext()) {
			Transaction t = itr.next();
			if(t==null) continue;
			Calendar cal=Calendar.getInstance();
			cal.setTime(endDate);
			cal.add(Calendar.HOUR, 24);
			if(t.getDate().compareTo(startDate)>=0 && t.getDate().compareTo(cal.getTime())<0) {
				Transaction currTransaction = t;
				int tid=currTransaction.getTransactionId();
				String ttype=currTransaction.getTransactionType();
				Date date = currTransaction.getDate();
				Double bal = currTransaction.getBalance();
				Double amt = currTransaction.getAmount();
				sb.append("Id: "+tid+"--"+ttype+" of amount  Rs "+amt+" on "+date+". Balance: Rs "+bal+"\n");

			}
		}
		String s=sb.toString();
		return s;
	}

	public String fundTransfer(int senderAcc, int receiverAcc, double amount) throws Exception{
		Account accountFrom = bankDaoImpl.getByAccountNo(senderAcc);
		Account accountTo = bankDaoImpl.getByAccountNo(receiverAcc);
		if(accountFrom == null || accountTo==null) throw new InvalidAccountException("Account not found");
		if(accountFrom.getBalance()-amount<minimumBalance) throw new InsufficientFundException("Insufficient Funds");
		if(amount<0) throw new NegativeAmountException("Amount cannot be negative");
		
		withdraw(senderAcc,amount);
		deposit(receiverAcc,amount);
		String str="";
		accountFrom = bankDaoImpl.getByAccountNo(senderAcc);
		accountTo = bankDaoImpl.getByAccountNo(receiverAcc);
		str+="Remaining Balance in your account: "+accountFrom.getBalance();
		str+="\nRemaining Balance in receiver account: "+accountTo.getBalance();
		return str;
	}

	public boolean isInactive(int accountNo) throws InvalidAccountException, FileNotFoundException, IOException, SQLException {
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, -1);
		List<Transaction> transactions=account.getTransactions();
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


	public String lastNTransactions(int accountNo, int n) throws InvalidAccountException, FileNotFoundException, IOException, SQLException {
		Account account = bankDaoImpl.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		
		List<Transaction> transactions = account.getTransactions();
		if(transactions.size()==0) return "No transactions found";
		int count=0;
		StringBuffer tran = new StringBuffer("");
		for(int i=transactions.size()-1;count<n && i>=0;count++,i--) {
			Transaction currTransaction = transactions.get(i);
			int tid=currTransaction.getTransactionId();
			String ttype=currTransaction.getTransactionType();
			Date date = currTransaction.getDate();
			Double bal = currTransaction.getBalance();
			Double amt = currTransaction.getAmount();
			tran.append("Id: "+tid+"--"+ttype+" of amount  Rs "+amt+" on "+date+". Balance: Rs "+bal+"\n");

		}
		String s=tran.toString();
		return s;
	}
	public void closeConnection() throws Exception{
		if(bankDaoImpl instanceof BankDaoInt) {
			BankDaoImpl bdi = (BankDaoImpl)bankDaoImpl;
			bdi.closeConn();
		}
	}
	
}
