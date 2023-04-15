package com.cg.bankapp.command.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.command.entities.Transaction;
import com.cg.bankapp.command.service.TransactionCommandService;
import com.cg.bankapp.dtos.TransactionDTO;

@RestController
public class TransactionCommandController {
	
	@Autowired
	private TransactionCommandService service;

	@PostMapping(value="/addTransactionDetails",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionDTO> addTransactionDetails(@RequestBody TransactionDTO requestTransactionDTO){
		Transaction transaction = new Transaction();
		System.out.println("transaction controller: "+requestTransactionDTO);
		BeanUtils.copyProperties(requestTransactionDTO, transaction);
		TransactionDTO responseTransactionDTO = new TransactionDTO();
		System.out.println("controller: "+requestTransactionDTO.getTransactionId());
		BeanUtils.copyProperties(service.addTransactionDetails(transaction), responseTransactionDTO);
		return new ResponseEntity<TransactionDTO>(responseTransactionDTO,HttpStatus.OK);
	}
}
