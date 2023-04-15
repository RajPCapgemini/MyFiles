package com.bank.util;

import com.bank.bean.*;
import java.util.*;

public class AccountUtil {
	private ArrayList<Account> accounts;
	final double MINIMUMBALANCE=1000;
	public  double getMinimumBalance() {
		return MINIMUMBALANCE;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public AccountUtil() {
		accounts=new ArrayList<Account>();
		accounts.add(new Account(10000,10000,new Customer(100,"R","P"),new ArrayList<Transaction>()));
		accounts.add(new Account(10001,15000,new Customer(101,"A","S"),new ArrayList<Transaction>())); ;
		accounts.add(new Account(10002,15500,new Customer(102,"S","B"),new ArrayList<Transaction>()));
		accounts.add(new Account(10003,14000,new Customer(103,"R","B"),new ArrayList<Transaction>()));
		accounts.add(new Account(10004,13500,new Customer(104,"B","S"),new ArrayList<Transaction>()));
		accounts.add(new Account(10005,20000,new Customer(105,"B","C"),new ArrayList<Transaction>()));
		accounts.add(new Account(10006,15600,new Customer(106,"M","C"),new ArrayList<Transaction>()));
		accounts.add(new Account(10007,15080,new Customer(107,"B","K"),new ArrayList<Transaction>()));
		accounts.add(new Account(10008,19000,new Customer(108,"F","K"),new ArrayList<Transaction>()));
		accounts.add(new Account(10009,22000,new Customer(109,"C","T"),new ArrayList<Transaction>()));
	}
}
