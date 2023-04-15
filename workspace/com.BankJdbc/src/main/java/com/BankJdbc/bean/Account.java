package com.BankJdbc.bean;

import java.util.*;

public class Account {
	private int accountNo;
	private double balance;
	private Customer customer;
	private List<Transaction> transactions;
	public Account() {
		
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public Account(int accountNo, double balance, Customer customer, List<Transaction> transactions) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.customer = customer;
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", balance=" + balance + ", customer=" + customer + ", transactions="
				+ transactions + "]";
	}
	
	
}
