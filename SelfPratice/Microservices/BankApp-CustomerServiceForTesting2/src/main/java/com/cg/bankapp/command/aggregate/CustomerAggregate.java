package com.cg.bankapp.command.aggregate;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.cg.bankapp.command.CustomerCreateCommand;
import com.cg.bankapp.command.events.CustomerCreateEvent;

import lombok.extern.slf4j.Slf4j;

@Aggregate
@Slf4j
public class CustomerAggregate {
	@AggregateIdentifier
	private String uid;
	private int id;
	private String firstName;
	private String lastName;
	
	@CommandHandler
	public  CustomerAggregate(CustomerCreateCommand customerCommand) {
		CustomerCreateEvent customerCreateEvent = new CustomerCreateEvent();
		BeanUtils.copyProperties(customerCommand	, customerCreateEvent);
		AggregateLifecycle.apply(customerCreateEvent);
	}
	
	@EventSourcingHandler
	public void customerCreateEventSourcingHandler(CustomerCreateEvent customerCreateEvent) {
		this.id=customerCreateEvent.getId();
		this.uid =customerCreateEvent.getUid();
		this.firstName= customerCreateEvent.getFirstName();
		this.lastName = customerCreateEvent.getLastName();
	}
}