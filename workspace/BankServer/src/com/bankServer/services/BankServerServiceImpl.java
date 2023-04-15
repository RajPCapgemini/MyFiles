package com.bankServer.services;

import com.bankServer.bean.*;
import com.bankServer.dao.*;
import java.util.*;

public class BankServerServiceImpl implements BankServerService{
	private BankServerDao bankServerDaoImpl;
	public static int transactionId=1000001,accountSeq=0;
	private Account account;
	public BankServerServiceImpl(){
		bankServerDaoImpl=new BankServerDaoImpl();
	}
	@Override
	public double showBalance(int accountNo) {
		// TODO Auto-generated method stub
		Account account = bankServerDaoImpl.getByAccountNo(accountNo);
		return account.getBalance();
	}

	@Override
	public void withdraw(int accountNo,double amount) {
		if(accountSeq>=5) {
			System.out.println("cannot add more transactions");
			return;
		}
		Account account = bankServerDaoImpl.getByAccountNo(accountNo);
		account.setBalance(account.getBalance()-amount);
		
		Transaction transaction = new Transaction(transactionId,new Date(),"Withdraw",account.getBalance()-amount,amount);
		Transaction transactions[]= account.getTransactions();
		transactions[accountSeq]=transaction;
		account.setTransactions(transactions);
		accountSeq++;
		transactionId++;
	}

	@Override
	public void deposit(int accountNo,double amount) {
		Account account = bankServerDaoImpl.getByAccountNo(accountNo);
		account.setBalance(account.getBalance()+amount);
		
	}

	@Override
	public String display(int accountNo) {
		Account account = bankServerDaoImpl.getByAccountNo(accountNo);
		Transaction transactions[]=account.getTransactions();
		String str="";
		for(int i=0;i<transactions.length;i++) {
			if(transactions[i]!=null)
				str+=transactions[i];
		}
		return str;
	}
	@Override
	public void fundTransfer(int receiverAcc,double amount) {
		Account accountTo = bankServerDaoImpl.getByAccountNo(receiverAcc);
//		Account accountFrom = bankServerDaoImpl.getByAccountNo(senderAcc);
//		BankServerServiceImpl  bankServerServiceImpl = new BankServerServiceImpl();
		this.account.setBalance(this.account.getBalance()-amount);
		accountTo.setBalance(accountTo.getBalance()+amount);
	}

}
