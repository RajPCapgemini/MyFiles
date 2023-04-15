package com.cg.bankapp.query.services;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.query.GetTransactionByAccountNoQuery;
import com.cg.bankapp.query.entities.Transaction;

@Component
public class TransactionQueryServiceImpl implements TransactionQueryService{
	
	@Autowired
	private QueryGateway queryGateway;

	@Override
	public List<Transaction> getAllTransactionDetails(int accountNo) {
		return queryGateway.query(new GetTransactionByAccountNoQuery(accountNo), ResponseTypes.multipleInstancesOf(Transaction.class)).join();
	}

}
