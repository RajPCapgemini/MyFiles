package com.cg.bankapp.dto;

import java.time.LocalDateTime;

public class TransactionDto {

	private LocalDateTime date;
	private String type;
	private double amount;
	private int accountNo;
	
	public TransactionDto() {
		super();
	}

	public TransactionDto(LocalDateTime date, String type, double amount,
			int accountNo) {
		super();
		this.date = date;
		this.type = type;
		this.amount = amount;
		this.accountNo = accountNo;
	}

	public LocalDateTime getdate() {
		return date;
	}

	public void setdate(LocalDateTime date) {
		this.date = date;
	}

	public String gettype() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}

	public double getamount() {
		return amount;
	}

	public void setamount(double amount) {
		this.amount = amount;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "TransactionDto [date=" + date + ", type=" + type
				+ ", amount=" + amount + ", accountNo=" + accountNo + "]";
	}
	
	

}
