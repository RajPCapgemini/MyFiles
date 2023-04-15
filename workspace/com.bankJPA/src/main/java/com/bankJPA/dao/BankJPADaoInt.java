package com.bankJPA.dao;

import com.bankJPA.bean.*;

public interface BankJPADaoInt {
	public Account getByAccountNo(int accountNo);
	public boolean save(Account account);
}
