package com.cg.bankapp.command.service;

import com.cg.bankapp.command.entities.Transaction;

public interface TransactionCommandService {

	public Transaction addTransactionDetails(Transaction transaction);
}
