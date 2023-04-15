package com.cg.bankapp.query.services;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.exceptions.AccountDetailsNotFoundException;
import com.cg.bankapp.query.GetAccountByIdQuery;
import com.cg.bankapp.query.entities.Account;

@Component
public class AccountQueryServiceImpl implements AccountQueryService{
	
	@Autowired
	private QueryGateway queryGateway;

	@Override
	public Account getAccountDetails(int accountNo) throws AccountDetailsNotFoundException{
		return queryGateway.query(new GetAccountByIdQuery(accountNo), ResponseTypes.instanceOf(Account.class)).join();
	}

}
