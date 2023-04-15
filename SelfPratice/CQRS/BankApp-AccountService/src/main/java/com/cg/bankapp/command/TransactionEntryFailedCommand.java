package com.cg.bankapp.command;

import java.time.LocalDateTime;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntryFailedCommand {

	@TargetAggregateIdentifier
	private String uid;
	private int transactionId;
	private String transactionType;
	private LocalDateTime transactionDate;
	private double transactionAmount;
	private int accountNo;
}
