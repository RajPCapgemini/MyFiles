package com.cg.bankapp.command.service;

import java.util.List;

import com.cg.bankapp.command.entities.Account;
import com.cg.bankapp.exceptions.*;

public interface AccountCommandService {
	public Account addAccountDetails(Account account) throws InvalidCustomerIdException;
	public Account withdrawAmount(int accountNo, double amount) throws AccountDetailsNotFoundException,HighValueTransactionException,NegativeAmountException,InsufficientFundsException, BankServerDownException;
	public Account depositAmount(int accountNo, double amount) throws AccountDetailsNotFoundException,HighValueTransactionException,NegativeAmountException, BankServerDownException;
	public List<Account> fundTransfer(int accountNoFrom, int accountNoTo, double amount) throws AccountDetailsNotFoundException,HighValueTransactionException,NegativeAmountException, InsufficientFundsException, BankServerDownException;
}
