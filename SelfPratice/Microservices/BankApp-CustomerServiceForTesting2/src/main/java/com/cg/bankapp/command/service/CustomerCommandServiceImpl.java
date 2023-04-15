package com.cg.bankapp.command.service;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.command.CustomerCreateCommand;
import com.cg.bankapp.command.entities.Customer;
import com.cg.bankapp.command.repositories.CustomerCommandRepository;

@Component
public class CustomerCommandServiceImpl implements CustomerCommandService{

		@Autowired private CommandGateway commandGateway;
	
		@Autowired private CustomerCommandRepository repository;

		@Override
		public Customer  addCustomerDetails(Customer customer) {
			
			customer = repository.save(customer);
			CustomerCreateCommand customerCommand = CustomerCreateCommand.builder()
						.id(customer.getId())
						.uid(UUID.randomUUID().toString())
						.firstName(customer.getFirstName())
						.lastName(customer.getLastName())
						.build();
			commandGateway.sendAndWait(customerCommand);
			return customer;
		}	
}