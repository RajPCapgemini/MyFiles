package com.cg.bankapp.query.services;

import com.cg.bankapp.exceptions.AccountDetailsNotFoundException;
import com.cg.bankapp.query.entities.Account;

public interface AccountQueryService {

	public Account getAccountDetails(int accountNo) throws AccountDetailsNotFoundException;
}
