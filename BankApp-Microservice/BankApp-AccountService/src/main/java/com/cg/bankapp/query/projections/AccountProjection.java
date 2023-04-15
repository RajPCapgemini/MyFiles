package com.cg.bankapp.query.projections;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.exceptions.AccountDetailsNotFoundException;
import com.cg.bankapp.query.GetAccountByIdQuery;
import com.cg.bankapp.query.entities.Account;
import com.cg.bankapp.query.repositories.AccountQueryRepository;

@Component
public class AccountProjection {

	@Autowired
	private AccountQueryRepository repository;
	
	@QueryHandler
	public Account handleGetAccountByIdQuery(GetAccountByIdQuery accountQuery) throws AccountDetailsNotFoundException{
		return repository.findById(accountQuery.getAccountNo()).orElseThrow(()->new AccountDetailsNotFoundException("Account details not found for account number "+accountQuery.getAccountNo()));
	}
}
