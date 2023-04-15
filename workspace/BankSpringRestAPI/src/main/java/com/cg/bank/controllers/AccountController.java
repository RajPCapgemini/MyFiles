package com.cg.bank.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bank.exception.HighValueTransactionException;
import com.cg.bank.exception.InsufficientFundException;
import com.cg.bank.exception.InvalidAccountException;
import com.cg.bank.exception.InvalidDateException;
import com.cg.bank.exception.InvalidInputException;
import com.cg.bank.exception.NegativeAmountException;
import com.cg.bank.pojos.*;
import com.cg.bank.service.BankService;

@RestController
public class AccountController {

	@Autowired
	private BankService service;

	@PostMapping(value = { "/addAccount" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> addAccount(@RequestBody Customer customer) throws InvalidInputException {
		Account account = service.addAccount(customer.getFirstName(), customer.getLastName());
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	@GetMapping(value = { "/showBalance/{accountNo}" })
	public ResponseEntity<Double> showBalance(@PathVariable int accountNo) throws InvalidAccountException {
		double balance = service.showBalance(accountNo);
		return new ResponseEntity<Double>(balance, HttpStatus.OK);
	}

	@PostMapping(value = { "/withdraw" }, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Double> withdraw(@RequestParam int accountNo, @RequestParam double amount)
			throws InvalidAccountException, InsufficientFundException, NegativeAmountException,
			HighValueTransactionException {
		double balance = service.withdraw(accountNo, amount);
		return new ResponseEntity<Double>(balance, HttpStatus.OK);
	}

	@PostMapping(value = { "/deposit" }, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Double> deposit(@RequestParam int accountNo, @RequestParam double amount)
			throws InvalidAccountException, NegativeAmountException, HighValueTransactionException,
			InsufficientFundException {
		double balance = service.deposit(accountNo, amount);
		return new ResponseEntity<Double>(balance, HttpStatus.OK);
	}

	@PostMapping(value = { "/transferFund" }, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> fundTransfer(@RequestParam int senderAcc, @RequestParam int receiverAcc,
			@RequestParam double amount) throws InvalidAccountException, NegativeAmountException,
			HighValueTransactionException, InsufficientFundException {
		return new ResponseEntity<String>(service.fundTransfer(senderAcc, receiverAcc, amount), HttpStatus.OK);
	}

	@GetMapping(value = { "/lastTransactions/{accountNo}" })
	public ResponseEntity<List<Transaction>> last10Transaction(@PathVariable int accountNo)
			throws InvalidAccountException {
		List<Transaction> list = service.last10Transaction(accountNo);
		return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);
	}

	@DeleteMapping(value = { "/removeAccount" }, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Boolean> removeAccount(@RequestParam int accountNo) throws InvalidAccountException {
		return new ResponseEntity<Boolean>(service.deleteAccount(accountNo), HttpStatus.OK);
	}

	@GetMapping(value = { "/transactionsWithinDate" })
	public ResponseEntity<List<Transaction>> transactionWithinDate(@RequestParam int accountNo,
			@RequestParam String startDateStr, @RequestParam String endDateStr)
			throws InvalidAccountException, InvalidDateException {
		LocalDateTime startDate = LocalDateTime.parse(startDateStr), endDate = LocalDateTime.parse(endDateStr);
		return new ResponseEntity<List<Transaction>>(service.transactionWithinDate(accountNo, startDate, endDate),
				HttpStatus.OK);
	}

}
