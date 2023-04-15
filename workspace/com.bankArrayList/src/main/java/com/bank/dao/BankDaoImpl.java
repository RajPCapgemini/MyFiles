package com.bank.dao;

import java.util.Calendar;

import com.bank.bean.*;
import com.bank.exception.InvalidAccountException;
import com.bank.util.AccountUtil;
import java.util.*;

public class BankDaoImpl implements BankDaoInt{
	private AccountUtil accountUtil;
	public BankDaoImpl(){
		accountUtil = new AccountUtil();
	}

	public Account getByAccountNo(int accountNo) throws InvalidAccountException{
		ArrayList<Account> accounts=accountUtil.getAccounts();
		Iterator<Account> itr=accounts.iterator();
		while(itr.hasNext()) {
			Account acc=itr.next();
			if(acc.getAccountNo()==accountNo) {
				return acc;
			}
		}
//		for(int i=0;i<accounts.size();i++) {
//			if(accounts.get(i).getAccountNo()==accountNo) {
//				return accounts.get(i);
//			}
//		}
		throw new InvalidAccountException("Account not found");
	}

	public void inactiveAccounts() {
		ArrayList<Account> accounts=accountUtil.getAccounts();
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, -1);
		Iterator<Account> itr=accounts.iterator();
		while(itr.hasNext()) {
			Account acc=itr.next();
			ArrayList<Transaction> transactions=acc.getTransactions();
			Iterator<Transaction> itrT=transactions.iterator();
			boolean flag=true;
			while(itrT.hasNext()) {
				Transaction t = itrT.next();
				if(t==null) continue;
				if(t.getDate().compareTo(lastDate.getTime())>=0) {
					flag=false;
					break;
				}
			}
			if(flag) {
				System.out.println(acc);
			}
		}
//		for(int i=0;i<accounts.size();i++) {
//			ArrayList<Transaction> transactions=accounts.get(i).getTransactions();
//			boolean flag=true;
//			for(int j=0;j<transactions.size();j++) {
//				if(transactions.get(j)==null) continue;
//				if(transactions.get(j).getDate().compareTo(lastDate.getTime())>=0) {
//					flag=false;
//					break;
//				}
//			}
//			
//			if(flag) {
//				System.out.println(accounts.get(i));
//			}
//		}
		
	}

}
