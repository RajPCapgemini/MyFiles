package com.bankJPA.dao;

import java.util.List;

import com.bankJPA.bean.*;
import com.bankJPA.util.AccountUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class BankJPADaoImpl implements BankJPADaoInt{
	private AccountUtil accountUtil;
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private EntityTransaction trans = null;
	public BankJPADaoImpl() {
		accountUtil = new AccountUtil();
		emf = accountUtil.getEmf();
		em = accountUtil.getEm();
		trans = accountUtil.getTrans();
	}

	public Account getByAccountNo(int accountNo) {
		// TODO Auto-generated method stub
		trans.begin();
		Account account = em.find(Account.class, accountNo);
		trans.commit();
		return account;
	}

	public boolean save(Account account) {
		// TODO Auto-generated method stub
		trans.begin();
		Account currAccount =em.find(Account.class, account.getAccountNo());
		Customer currCustomer = account.getCustomer();
		if(em.find(Customer.class, currCustomer.getCustomerId())==null) {
			em.persist(account.getCustomer());
		}else {
			currCustomer.setFirstName(currCustomer.getFirstName());
			currCustomer.setLastName(currCustomer.getLastName());
		}
		if(em.find(Account.class, account.getAccountNo())==null) {
			em.persist(account);
		}
		else {
			currAccount.setBalance(account.getBalance());
			currAccount.setCustomer(currCustomer);
			currAccount.setTransactions(account.getTransactions());
		}
		List<Transaction> transactions = account.getTransactions();
		Transaction transaction=null;
		if(transactions.size()>0) {
			transaction = transactions.get(transactions.size()-1);
			em.persist(transaction);
		}
		trans.commit();
		return true;
	}
	public void closeResources() {
		accountUtil.closeResources();
	}

}
