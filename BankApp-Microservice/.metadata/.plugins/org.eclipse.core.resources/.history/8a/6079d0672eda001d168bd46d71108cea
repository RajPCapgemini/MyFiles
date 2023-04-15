package com.cg.bankapp.command.controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.command.entities.Customer;
import com.cg.bankapp.command.service.CustomerCommandService;
import com.cg.bankapp.dtos.CustomerDTO;

@RestController
public class CustomerCommandController {
	
	
	@Autowired private CustomerCommandService service; 

	@PostMapping (value = "/addCustomerDetails" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDTO> addCustomerDetails(@RequestBody CustomerDTO recivedCustomerDTO){
//		Customer  customer = new Customer();	
//		BeanUtils.copyProperties(recivedCustomerDTO, customer);
		CustomerDTO responseCustomerDTO = new CustomerDTO();
		BeanUtils.copyProperties(service.addCustomerDetails(recivedCustomerDTO), responseCustomerDTO);
		return new ResponseEntity<CustomerDTO>(responseCustomerDTO,HttpStatus.OK) ;	
	}
}