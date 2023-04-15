package com.bankJPA.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankJPA.pojos.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Component(value="bankDao")
public class BankJPADaoImpl implements BankJPADaoInt{
	
	@Autowired
	private EntityManagerFactory emf;
	

	public Account getByAccountNo(int accountNo) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Account account = em.find(Account.class, accountNo);
		em.getTransaction().commit();
		em.close();
		return account;
	}

	public boolean save(Account account) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
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
		em.getTransaction().commit();
		em.close();
		return true;
	}
	public void closeResources() {
		System.out.println("closed emf");
		emf.close();
	}

}
