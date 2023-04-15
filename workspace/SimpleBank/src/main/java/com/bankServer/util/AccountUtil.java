package com.bankServer.util;

import java.util.*;

import com.bankServer.bean.*;

public class AccountUtil {
	private Account accounts[];
	final double MINIMUMBALANCE=1000;
	private int transactionArraySize=10;
	public  double getMinimumBalance() {
		return MINIMUMBALANCE;
	}
	public Account[] getAccounts() {
		return accounts;
	}
	public void setTransactionArraySize(int transactionArraySize) {
		this.transactionArraySize=transactionArraySize;
	}
	public int getTransactionArraySize() {
		return transactionArraySize;
	}
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public AccountUtil() {
		accounts=new Account[10];
		accounts[0]=new Account(10000,10000,new Customer(100,"R","P"),new Transaction[10]);
		accounts[1]=new Account(10001,15000,new Customer(101,"A","S"),new Transaction[10]);
		accounts[2]=new Account(10002,15500,new Customer(102,"S","B"),new Transaction[10]);
		accounts[3]=new Account(10003,14000,new Customer(103,"R","B"),new Transaction[10]);
		accounts[4]=new Account(10004,13500,new Customer(104,"B","S"),new Transaction[10]);
		accounts[5]=new Account(10005,20000,new Customer(105,"B","C"),new Transaction[10]);
		accounts[6]=new Account(10006,15600,new Customer(106,"M","C"),new Transaction[10]);
		accounts[7]=new Account(10007,15080,new Customer(107,"B","K"),new Transaction[10]);
		accounts[8]=new Account(10008,19000,new Customer(108,"F","K"),new Transaction[10]);
		accounts[9]=new Account(10009,22000,new Customer(109,"C","T"),new Transaction[10]);
	}
	
}
