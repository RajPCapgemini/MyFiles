package com.bankServer.util;

import java.util.*;

import com.bankServer.bean.*;

public class AccountUtil {
	private Account accounts[];
	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public AccountUtil() {
		accounts=new Account[5];
		Customer customer=new Customer(101,"R","P");
		Transaction transactions[]=new Transaction[5];
		accounts[0]=new Account(10001,10000,customer,transactions);
		customer=new Customer(102,"A","S");
		accounts[1]=new Account(10002,15000,customer,transactions);
		customer=new Customer(103,"S","B");
		accounts[1]=new Account(10003,15000,customer,transactions);
		customer=new Customer(101,"R","B");
		accounts[1]=new Account(10004,15000,customer,transactions);
		customer=new Customer(101,"B","S");
		accounts[1]=new Account(10005,15000,customer,transactions);
	}
	
}
