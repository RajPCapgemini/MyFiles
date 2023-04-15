package com.bankJPA.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankJPA.dao.*;
import com.bankJPA.exception.*;
import com.bankJPA.pojos.*;

@Component(value="bankService")
public class BankJPAServiceImpl implements BankJPAServiceInt{
	
	@Autowired
	private BankJPADaoInt bankDao;
	
	public Account addAccount(String firstName, String lastName) {
		Customer customer = new Customer(firstName,lastName);
		Account account=new Account(0,customer);
		bankDao.save(account);
		return account;
	}
	public double showBalance(int accountNo) throws InvalidAccountException {
		Account account = bankDao.getByAccountNo(accountNo);
		if(account==null) throw new InvalidAccountException("Account does not exists");
		return account.getBalance();
	}
	public double withdraw(int accountNo, double amount) throws InvalidAccountException, NegativeAmountException, HighValueTransactionException, InsufficientFundException {
		Account account=bankDao.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account does not exists");
		if(amount<0) throw new NegativeAmountException("Amount cannot be negative");
		if(amount>=10000000) throw new HighValueTransactionException("Please wait for Income Tax Department visit");
		if(account.getBalance()-amount<0) throw new InsufficientFundException("Insufficient Funds");
		account.setBalance(account.getBalance() - amount);
		Transaction transaction = new Transaction("Debit",new Date(),amount,account.getBalance());
		List<Transaction> transactions=account.getTransactions();
		transaction.setAccount(account);
		transactions.add(transaction);
		account.setTransactions(transactions);
		bankDao.save(account);
		return account.getBalance();
	}
	public double deposit(int accountNo, double amount) throws InvalidAccountException, NegativeAmountException, HighValueTransactionException, InsufficientFundException {
		Account account=bankDao.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account does not exists");
		if(amount<0) throw new NegativeAmountException("Amount cannot be negative");
		if(amount>=10000000) throw new HighValueTransactionException("Please wait for Income Tax Department visit");
		
		account.setBalance(account.getBalance() + amount);
		Transaction transaction = new Transaction("Credit",new Date(),amount,account.getBalance());
		List<Transaction> transactions=account.getTransactions();
		transaction.setAccount(account);
		transactions.add(transaction);
		account.setTransactions(transactions);
		bankDao.save(account);
		return account.getBalance();
	}
	public String fundTransfer(int senderAcc, int receiverAcc, double amount) throws InvalidAccountException, NegativeAmountException, HighValueTransactionException, InsufficientFundException {
		Account accountFrom = bankDao.getByAccountNo(senderAcc);
		if(accountFrom == null) throw new InvalidAccountException("Account does not exists");
		Account accountTo = bankDao.getByAccountNo(receiverAcc);
		if(accountTo == null) throw new InvalidAccountException("Account does not exists");
		withdraw(senderAcc,amount);
		deposit(receiverAcc,amount);
		String str="";
		str+="Remaining Balance in your account: "+accountFrom.getBalance();
		str+="\nRemaining Balance in receiver account: "+accountTo.getBalance();
		return str;
	}
	public List<Transaction> last10Transaction(int accountNo) throws InvalidAccountException{
		// TODO Auto-generated method stub
		Account account=bankDao.getByAccountNo(accountNo);
		if(account==null) throw new InvalidAccountException("Account does not exists :( ");
		List<Transaction> transactions = account.getTransactions();
		List<Transaction> trans=new ArrayList<Transaction>();
		int i=transactions.size()-1,cnt=0;
		while(i>=0 && cnt<10) {
			trans.add(transactions.get(i));
			i--;
			cnt++;
		}
		return trans;
	}
	public List<Transaction> transactionWithinDate(int accountNo, Date startDate, Date endDate) throws InvalidAccountException, InvalidDateException {
		Account account = bankDao.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		if(startDate.compareTo(endDate)>0) {
			throw new InvalidDateException("Start date should be before than end date");
		}
		List<Transaction> trans = new ArrayList<Transaction>();
		List<Transaction> transactions = account.getTransactions();
		Iterator<Transaction> itr=transactions.iterator();
		while(itr.hasNext()) {
			Transaction t = itr.next();
			if(t==null) continue;
			Calendar cal=Calendar.getInstance();
			cal.setTime(endDate);
			cal.add(Calendar.HOUR, 24);
			if(t.getTransactionDate().compareTo(startDate)>=0 && t.getTransactionDate().compareTo(cal.getTime())<0) {
				trans.add(t);
			}
		}
		return trans;
	}
	public List<Transaction> lastNTransaction(int accountNo,int n) throws InvalidAccountException {
		Account account = bankDao.getByAccountNo(accountNo);
		if(account == null) throw new InvalidAccountException("Account not found");
		List<Transaction> trans = new ArrayList<Transaction>();
		List<Transaction> transactions = account.getTransactions();
		int count=0;
		for(int i=transactions.size()-1;count<n && i>=0;count++,i--) {
			trans.add(transactions.get(i));
		}
		return trans;
	}
	public void closeResources() {
		if(bankDao instanceof BankJPADaoInt) {
			BankJPADaoImpl newBankDao = (BankJPADaoImpl)bankDao;
			newBankDao.closeResources();
		}
	}

}
