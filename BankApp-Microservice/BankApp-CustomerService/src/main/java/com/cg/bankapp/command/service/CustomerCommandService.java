package com.cg.bankapp.command.service;

import com.cg.bankapp.command.entities.Customer;
import com.cg.bankapp.dtos.CustomerDTO;
public interface CustomerCommandService {
	public Customer addCustomerDetails(CustomerDTO customerDTO);
	
}