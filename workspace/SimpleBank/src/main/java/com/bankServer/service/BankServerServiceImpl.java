package com.bankServer.service;

import java.util.Calendar;
import java.util.Date;
import com.bankServer.exception.*;
import com.bankServer.util.AccountUtil;
import com.bankServer.bean.Account;
import com.bankServer.bean.Transaction;
import com.bankServer.dao.BankServerDao;
import com.bankServer.dao.BankServerDaoImpl;

public class BankServerServiceImpl implements BankServerService{
	private BankServerDao bankServerDaoImpl;
	public static int transactionId=100001;
	public BankServerServiceImpl(){
		bankServerDaoImpl=new BankServerDaoImpl();
	}
	public double showBalance(int accountNo) throws InvalidAccountException{
		// TODO Auto-generated method stub
		Account account = bankServerDaoImpl.getByAccountNo(accountNo);
		if(account==null) {
			throw new InvalidAccountException("Account does not exits");
		}
		return account.getBalance();
	}

	public double withdraw(int accountNo, double amount) throws InsufficientFundException,InvalidAccountException,NegativeAmountException{
		// TODO Auto-generated method stub
		Account account = bankServerDaoImpl.getByAccountNo(accountNo);
		if(account==null) {
			throw new InvalidAccountException("Account does not exits");
		}
		if(account.getBalance()-amount<bankServerDaoImpl.getMinimumBalance()) {
			throw new InsufficientFundException("Insufficient funds");
		}
		if(amount<0) {
			throw new NegativeAmountException("Amount cannot be negative");
		}
		Transaction transactions[]= account.getTransactions();
		
		Transaction newTransaction = new Transaction(transactionId,new Date(),"Debit",account.getBalance()-amount,amount);
		int accountSeq=0;
		while(accountSeq<10) {
			if(transactions[accountSeq]==null) break;
			accountSeq++;
		}
		if(accountSeq==10) {
			for(int i=0;i<transactions.length-1;i++) {
				transactions[i]=transactions[i+1];
			}
			accountSeq--;
		}
		transactions[accountSeq]=newTransaction;
		account.setTransactions(transactions);
		account.setBalance(account.getBalance()-amount);
		transactionId++;
		return account.getBalance();
	}

	public double deposit(int accountNo, double amount) throws InvalidAccountException,NegativeAmountException{
		Account account = bankServerDaoImpl.getByAccountNo(accountNo);
		if(account==null) {
			throw new InvalidAccountException("Account does not exits");
		}
		if(amount<0) {
			throw new NegativeAmountException("Amount cannot be negative");
		}
		Transaction transaction = new Transaction(transactionId,new Date(),"Credit",account.getBalance()-amount,amount);
		Transaction transactions[]= account.getTransactions();
		int accountSeq=0;
		while(accountSeq<10) {
			if(transactions[accountSeq]==null) break;
			accountSeq++;
		}
		if(accountSeq==10) {
			for(int i=0;i<transactions.length-1;i++) {
				transactions[i]=transactions[i+1];
			}
			accountSeq--;
		}
		transactions[accountSeq]=transaction;
		account.setTransactions(transactions);
		account.setBalance(account.getBalance()+amount);
		transactionId++;
		return account.getBalance();
	}

	public String display(int accountNo) throws InvalidAccountException{
		// TODO Auto-generated method stub
		Account account = bankServerDaoImpl.getByAccountNo(accountNo);
		if(account==null) {
			throw new InvalidAccountException("Account does not exits");
		}
		Transaction transactions[]=account.getTransactions();
//		for(int i=0;i<transactions.length;i++) System.out.println(transactions[i]);
		String str="";
		for(int i=transactions.length-1;i>=0;i--) {
			if(transactions[i]!=null)
				str+=transactions[i]+"\n";
		}
		return str;
	}
	public String displayTransactionDuration(int accountNo,Date startDate,Date endDate) throws InvalidAccountException{
		Account account = bankServerDaoImpl.getByAccountNo(accountNo);
		if(account==null) {
			throw new InvalidAccountException("Account does not exits");
		}
		Transaction transactions[]=account.getTransactions();
		if(transactions==null) {
			return "No transactions";
		}
		String str="";
		for(int i=0;i<transactions.length;i++) {
			if(transactions[i]==null) continue;
			Calendar cal=Calendar.getInstance();
			cal.setTime(endDate);
			cal.add(Calendar.HOUR, 24);
			if(transactions[i].getDate().compareTo(startDate)>=0 && transactions[i].getDate().compareTo(cal.getTime())<0) {
				str+=transactions[i];
			}
		}
		return str;
	}

	public String fundTransfer(int senderAcc,int receiverAcc, double amount) throws InsufficientFundException,InvalidAccountException,NegativeAmountException{
		// TODO Auto-generated method stub
		Account accountTo = bankServerDaoImpl.getByAccountNo(receiverAcc);
		Account accountFrom = bankServerDaoImpl.getByAccountNo(senderAcc);
		if(accountTo==null || accountFrom==null) {
			throw new InvalidAccountException("Account does not exits");
		}
		if(accountFrom.getBalance()-amount<bankServerDaoImpl.getMinimumBalance()) {
			throw new InsufficientFundException("Insufficient funds");
		}
		if(amount<0) {
			throw new NegativeAmountException("Amount cannot be negative");
		}
//		BankServerServiceImpl  bankServerServiceImpl = new BankServerServiceImpl();
		withdraw(accountFrom.getAccountNo(),amount);
		deposit(accountTo.getAccountNo(),amount);
		String str="";
		str+="Remaining balance in your account: "+accountTo.getBalance();
		str+="\nRemaining balance in receiver account: "+accountFrom.getBalance();
		return str;
	}
	public boolean isInactive(int accountNo) throws InvalidAccountException{
		Account account = bankServerDaoImpl.getByAccountNo(accountNo);
		if(account==null) {
			throw new InvalidAccountException("Account does not exits");
		}
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, -1);
		Transaction transactions[]=account.getTransactions();
		for(int j=0;j<transactions.length;j++) {
			if(transactions[j]==null) continue;
//			System.out.println("date last year: "+lastDate.getTime());
			Date d=lastDate.getTime();
//			System.out.println(transactions[j].getDate()+"/"+d);
			int val=transactions[j].getDate().compareTo(d);
			if(val>=0) {
				return false;
			}
		}
		return true;
	}
	public void inactiveAccounts() {
		bankServerDaoImpl.inactiveAccounts();
	}
	public Transaction [] lastNTransactions(int accountNo,int n) throws InvalidAccountException{
		Account account = bankServerDaoImpl.getByAccountNo(accountNo);
		Transaction returnTransactions[]=new Transaction[n];
		if(account==null) {
			throw new InvalidAccountException("Account does not exits");
		}
		Transaction transactions[]=account.getTransactions();
		int i=transactions.length-1,idx=0;
		while(i>=0 && transactions[i]==null) {
			i--;
		}
		while(i>=0 && n>0) {
			returnTransactions[idx]=transactions[i];
			idx++;
			i--;
			n--;
		}
		return returnTransactions;
	}

}
