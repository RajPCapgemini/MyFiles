package com.cg.bankapp.query.services;

import java.time.LocalDateTime;
import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.exceptions.InvalidDateException;
import com.cg.bankapp.query.GetTransactionBetweenDatesQuery;
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

	@Override
	public List<Transaction> getAllTransactionDetailsBetweenDates(int accountNo,LocalDateTime startDate,LocalDateTime endDate) throws InvalidDateException {
		if(startDate.compareTo(endDate)>0)
			throw new InvalidDateException("Start date cannot be after end date!!!");
		return queryGateway.query(new GetTransactionBetweenDatesQuery(accountNo,startDate,endDate), ResponseTypes.multipleInstancesOf(Transaction.class)).join();
	}

}
