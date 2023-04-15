package com.bank.dao;

import com.bank.bean.Account;
import com.bank.exception.InvalidAccountException;

public interface BankDaoInt {
	public Account getByAccountNo(int accountNo)throws InvalidAccountException;
	public void inactiveAccounts();
}
