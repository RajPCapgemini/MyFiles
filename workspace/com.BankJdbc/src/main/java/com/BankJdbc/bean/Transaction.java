package com.BankJdbc.bean;

import java.util.Date;

public class Transaction {
	private int transactionId;
	private Date date;
	private String transactionType;
	private double amount;
	private double balance;
	public Transaction() {}
	public Transaction(int transactionId, Date date, String transactionType, double amount, double balance) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.transactionType = transactionType;
		this.balance = balance;
		this.amount = amount;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", date=" + date + ", transactionType=" + transactionType
				+ ", amount=" + amount + ", balance=" + balance + "]";
	}
}
