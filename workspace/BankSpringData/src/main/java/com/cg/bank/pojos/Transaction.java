package com.cg.bank.pojos;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "transaction_id")
	private int transactionId;
	
	@Column(name = "transaction_type")
	private String transactionType;
	
	@Column(name = "transaction_date")
	private Date transactionDate;
	
	@Column(name = "transaction_amount")
	private double transactionAmount;
	
	@Column(name = "transaction_balance")
	private double transactionBalance;
	
	@ManyToOne
	private Account account;
	

	public Transaction() {
		super();
	}

	public Transaction(int transactionId, String transactionType, Date transactionDate, double transactionAmount,
			double transactionBalance) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionBalance = transactionBalance;
	}

	public Transaction(String transactionType, Date transactionDate, double transactionAmount,
			double transactionBalance) {
		super();
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionBalance = transactionBalance;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public double getTransactionBalance() {
		return transactionBalance;
	}

	public void setTransactionBalance(double transactionBalance) {
		this.transactionBalance = transactionBalance;
	}

	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactionDate=" + transactionDate + ", transactionAmount=" + transactionAmount
				+ ", transactionBalance=" + transactionBalance;
	}
	
	
}
