package com.bankJPA.dao;

import com.bankJPA.pojos.*;

public interface BankJPADaoInt {
	public Account getByAccountNo(int accountNo);
	public boolean save(Account account);
}
