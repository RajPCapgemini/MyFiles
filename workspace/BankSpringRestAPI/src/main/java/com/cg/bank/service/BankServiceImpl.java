package com.cg.bank.service;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bank.dao.*;
import com.cg.bank.exception.*;
import com.cg.bank.pojos.*;

@Component(value = "bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	private AccountDao bankDao;

	@Autowired
	private TransactionsDao transactionsDao;

	@Transactional(rollbackFor = Exception.class)
	public Account addAccount(String firstName, String lastName) throws InvalidInputException {
		if (!firstName.matches("^[a-zA-Z]+$"))
			throw new InvalidInputException("Invalid Input");
		if (!lastName.matches("^[a-zA-Z]+$"))
			throw new InvalidInputException("Invalid Input");
		return bankDao.save(new Account(0, new Customer(firstName, lastName)));
	}

	public double showBalance(int accountNo) throws InvalidAccountException {
		Account account = getAccountDetails(accountNo);
		return account.getBalance();
	}

	@Transactional(rollbackFor = Exception.class)
	public double withdraw(int accountNo, double amount) throws InvalidAccountException, NegativeAmountException,
			HighValueTransactionException, InsufficientFundException {
		Account account = getAccountDetails(accountNo);
		if (amount < 0)
			throw new NegativeAmountException("Amount cannot be negative");
		if (amount >= 10000000)
			throw new HighValueTransactionException("Please wait for Income Tax Department visit");
		if (account.getBalance() - amount < 0)
			throw new InsufficientFundException("Insufficient Funds");
		account.setBalance(account.getBalance() - amount);
		Transaction transaction = new Transaction("Debit", LocalDateTime.now(), amount, account.getBalance());
		List<Transaction> transactions = account.getTransactions();
		transaction.setAccount(account);
		transactions.add(transaction);
		account.setTransactions(transactions);
		bankDao.save(account);
		return account.getBalance();
	}

	@Transactional(rollbackFor = Exception.class)
	public double deposit(int accountNo, double amount) throws InvalidAccountException, NegativeAmountException,
			HighValueTransactionException, InsufficientFundException {
		Account account = getAccountDetails(accountNo);
		if (amount < 0)
			throw new NegativeAmountException("Amount cannot be negative");
		if (amount >= 10000000)
			throw new HighValueTransactionException("Please wait for Income Tax Department visit");

		account.setBalance(account.getBalance() + amount);
		Transaction transaction = new Transaction("Credit", LocalDateTime.now(), amount, account.getBalance());
		List<Transaction> transactions = account.getTransactions();
		transaction.setAccount(account);
		transactions.add(transaction);
		account.setTransactions(transactions);
		bankDao.save(account);
		return account.getBalance();
	}

	@Transactional(rollbackFor = Exception.class)
	public String fundTransfer(int senderAcc, int receiverAcc, double amount) throws InvalidAccountException,
			NegativeAmountException, HighValueTransactionException, InsufficientFundException {
		Account accountFrom = getAccountDetails(senderAcc);
		Account accountTo = getAccountDetails(receiverAcc);
		withdraw(senderAcc, amount);
		deposit(receiverAcc, amount);
		String str = "";
		str += "Remaining Balance in sender account: " + accountFrom.getBalance();
		str += "\nRemaining Balance in receiver account: " + accountTo.getBalance();
		return str;
	}

	public List<Transaction> last10Transaction(int accountNo) throws InvalidAccountException {
		// TODO Auto-generated method stub
		Account account = getAccountDetails(accountNo);
		return transactionsDao.findFirst10ByAccountOrderByTransactionDateDesc(account);
	}

	public List<Transaction> transactionWithinDate(int accountNo, LocalDateTime startDate, LocalDateTime endDate) throws InvalidAccountException, InvalidDateException{
		Account account = getAccountDetails(accountNo);
		if (startDate.compareTo(endDate) > 0)
			throw new InvalidDateException("Start date should be before than end date");
		return transactionsDao.findByAccountAndTransactionDateBetween(account, startDate, endDate);
	}

	public List<Transaction> lastNTransaction(int accountNo, int n) throws InvalidAccountException {
		Account account = getAccountDetails(accountNo);
		List<Transaction> trans = new ArrayList<Transaction>();
		List<Transaction> transactions = account.getTransactions();
		int count = 0;
		for (int i = transactions.size() - 1; count < n && i >= 0; count++, i--)
			trans.add(transactions.get(i));
		return trans;
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean deleteAccount(int accountNo) throws InvalidAccountException {
		if (!bankDao.existsById(accountNo))
			throw new InvalidAccountException("Account does not exits");
		bankDao.deleteById(accountNo);
		return true;
	}

	private Account getAccountDetails(int accountNo) throws InvalidAccountException {
		return bankDao.findById(accountNo)
				.orElseThrow(() -> new InvalidAccountException("Account does not exists"));
	}
}
