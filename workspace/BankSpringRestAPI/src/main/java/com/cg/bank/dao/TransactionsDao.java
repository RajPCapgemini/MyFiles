package com.cg.bank.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bank.pojos.Account;
import com.cg.bank.pojos.Transaction;

public interface TransactionsDao extends JpaRepository<Transaction, Integer>{
	public List<Transaction> findFirst10ByAccountOrderByTransactionDateDesc(Account account);
	public List<Transaction> findByAccountAndTransactionDateBetween(Account account,LocalDateTime startDate,LocalDateTime endDate);
}
