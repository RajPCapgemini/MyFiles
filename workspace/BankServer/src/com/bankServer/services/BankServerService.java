package com.bankServer.services;

public interface BankServerService {
	public double showBalance(int accountNo);
	public void withdraw(int accountNo,double amount);
	public void deposit(int accountNo,double amount);
	public String display(int accountNo);
	public void fundTransfer(int receiverAcc,double amount);
}
