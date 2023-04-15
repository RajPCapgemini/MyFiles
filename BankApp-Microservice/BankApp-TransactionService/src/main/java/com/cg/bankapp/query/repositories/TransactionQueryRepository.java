package com.cg.bankapp.query.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankapp.query.entities.Transaction;

public interface TransactionQueryRepository extends JpaRepository<Transaction, Integer>{

	public List<Transaction> findByAccountNoOrderByTransactionDateDesc(int accountNo);
	public List<Transaction> findByAccountNoAndTransactionDateBetweenOrderByTransactionDateDesc(int accountNo,LocalDateTime startDate,LocalDateTime endDate);
}
