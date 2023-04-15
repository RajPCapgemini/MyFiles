package com.cg.bankapp.query.services;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.bankapp.exceptions.InvalidDateException;
import com.cg.bankapp.query.entities.Transaction;

public interface TransactionQueryService {

	public List<Transaction> getAllTransactionDetails(int accountNo);
	
	public List<Transaction> getAllTransactionDetailsBetweenDates(int accountNo,LocalDateTime startDate,LocalDateTime endDate) throws InvalidDateException;
}