package com.bean;

public class Account {
	private int accid;
	private double balance;
	public Account() {
		
	}
	public Account(int accid, double balance) {
		super();
		this.accid = accid;
		this.balance = balance;
	}
	public int getAccid() {
		return accid;
	}
	public void setAccid(int accid) {
		this.accid = accid;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accid=" + accid + ", balance=" + balance + "]";
	}
	
}
