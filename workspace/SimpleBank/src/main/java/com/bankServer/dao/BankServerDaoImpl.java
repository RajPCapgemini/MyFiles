package com.bankServer.dao;

import com.bankServer.bean.*;
import java.util.*;
import com.bankServer.exception.*;
import com.bankServer.util.AccountUtil;

public class BankServerDaoImpl implements BankServerDao{
	private AccountUtil accountUtil;
	public BankServerDaoImpl() {
		accountUtil=new AccountUtil();
	}
	public double getMinimumBalance() {
		return accountUtil.getMinimumBalance();
	}
	public Account getByAccountNo(int accountNo){
		// TODO Auto-generated method stub
		Account accounts[] = accountUtil.getAccounts();
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i]==null) continue;
			if(accounts[i].getAccountNo()==accountNo) {
				return accounts[i];
			}
		}
		return null;
	}
	public void inactiveAccounts() {
		Account accounts[]=accountUtil.getAccounts();
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, -1);
		for(int i=0;i<accounts.length;i++) {
			Transaction transactions[]=accounts[i].getTransactions();
			boolean flag=true;
			for(int j=0;j<transactions.length;j++) {
				if(transactions[j]==null) continue;
				if(transactions[j].getDate().compareTo(lastDate.getTime())>=0) {
					flag=false;
					break;
				}
			}
			if(flag) {
				System.out.println(accounts[i]);
			}
		}
	}
	public int getTransactionArraySize() {
		return accountUtil.getTransactionArraySize();
	}

}
