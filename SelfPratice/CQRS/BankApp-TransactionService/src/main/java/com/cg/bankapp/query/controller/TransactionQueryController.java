package com.cg.bankapp.query.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.dtos.TransactionDTO;
import com.cg.bankapp.query.entities.Transaction;
import com.cg.bankapp.query.services.TransactionQueryService;

@RestController
public class TransactionQueryController {

	@Autowired
	private TransactionQueryService service;
	
	@GetMapping(value="/getAllTransactionDetails",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionDTO>> getTransactionDetails(@RequestBody TransactionDTO request){
		List<TransactionDTO> response = new ArrayList<>();
		List<Transaction> transactions=service.getAllTransactionDetails(request.getAccountNo());
		for(Transaction transaction : transactions) {
			TransactionDTO transactionDTO = new TransactionDTO();
			BeanUtils.copyProperties(transaction, transactionDTO);
			response.add(transactionDTO);
		}
		return new ResponseEntity<List<TransactionDTO>>(response,HttpStatus.OK);
	}
}
