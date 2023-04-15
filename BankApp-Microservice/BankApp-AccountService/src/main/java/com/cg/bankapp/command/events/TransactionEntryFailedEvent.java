package com.cg.bankapp.command.events;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionEntryFailedEvent {

	private String uid;
	private int transactionId;
	private String transactionType;
	private LocalDateTime transactionDate;
	private double transactionAmount;
	private int accountNo;
}
