package com.cg.bankapp.query.projections;

import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.query.GetTransactionByAccountNoQuery;
import com.cg.bankapp.query.entities.Transaction;
import com.cg.bankapp.query.repositories.TransactionQueryRepository;

@Component
public class TransactionProjection {
	
	@Autowired
	private TransactionQueryRepository repo;
	
	@QueryHandler
	public List<Transaction> handleGetTransactionByAccountNoQuery(GetTransactionByAccountNoQuery query){
		return repo.findByAccountNoOrderByTransactionDateDesc(query.getAccountNo());
	}

}
