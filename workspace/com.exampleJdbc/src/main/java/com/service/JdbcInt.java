package com.service;

public interface JdbcInt {
	public double showBalance(int accountNo);
	public double deposit(int accountNo,double amount);
	public double withdraw(int accountNo,double amount);
}
