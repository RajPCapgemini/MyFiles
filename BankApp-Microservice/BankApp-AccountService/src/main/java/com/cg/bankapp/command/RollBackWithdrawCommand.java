package com.cg.bankapp.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RollBackWithdrawCommand {

	@TargetAggregateIdentifier
	private String uid;
	private int accountNo;
	private double balance;
	private int customerId;
}
