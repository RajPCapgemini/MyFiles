package com.cg.bank.pojos;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "account_no")
	private int accountNo;
	
	@Column(name = "balance")
	private double balance;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(targetEntity = Transaction.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Transaction> transactions;

	public Account() {
		super();
	}

	public Account(int accountNo, double balance, Customer customer, List<Transaction> transactions) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.customer = customer;
		this.transactions = transactions;
	}
	public Account(double balance,Customer customer) {
		this.balance = balance;
		this.customer = customer;
		this.transactions=new ArrayList<Transaction>();
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

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", balance=" + balance + ", customer=" + customer + ", transactions="
				+ transactions + "]";
	}
	
}
