package com.cg.bankapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accoutNo;
	private double balance;
	private int customerId;
	
	public Account() {}

	public int getAccoutNo() {
		return accoutNo;
	}

	public void setAccoutNo(int accoutNo) {
		this.accoutNo = accoutNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
