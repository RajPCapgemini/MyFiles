package com.cg.bankapp.command.aggregate;

import java.time.LocalDateTime;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.cg.bankapp.command.TransactionEntryFailedCommand;
import com.cg.bankapp.command.events.TransactionEntryFailedEvent;

import lombok.Data;

@Data
@Aggregate
public class TransactionAggregate {

	@AggregateIdentifier
	private String uid;
	private int transactionId;
	private String transactionType;
	private LocalDateTime transactionDate;
	private double transactionAmount;
	private int accountNo;
	
	@CommandHandler
	public TransactionAggregate(TransactionEntryFailedCommand command) {
		TransactionEntryFailedEvent event = new TransactionEntryFailedEvent();
		BeanUtils.copyProperties(command, event);
		AggregateLifecycle.apply(event);
	}

	@EventSourcingHandler
	public void transactionEntryFailedEventSourcingHandler(TransactionEntryFailedEvent event) {
		this.uid = event.getUid();
		this.transactionId = event.getTransactionId();
		this.transactionType = event.getTransactionType();
		this.transactionDate = event.getTransactionDate();
		this.transactionAmount = event.getTransactionAmount();
		this.accountNo = event.getAccountNo();
	}
	
	
}
