package com.cg.bankapp.query.services;

import java.util.List;

import com.cg.bankapp.query.entities.Transaction;

public interface TransactionQueryService {

	public List<Transaction> getAllTransactionDetails(int accountNo);
}
