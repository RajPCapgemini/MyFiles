package com.cg.bankapp.command;

import java.time.LocalDateTime;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionCreateCommand {

	@TargetAggregateIdentifier
	private String uid;
	private int transactionId;
	private String transactionType;
	private LocalDateTime transactionDate;
	private double transactionAmount;
	private int accountNo;
}
