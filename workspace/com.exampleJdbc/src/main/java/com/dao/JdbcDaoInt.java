package com.dao;

import com.bean.Account;

public interface JdbcDaoInt {
	public boolean save(Account account);
	public Account getById(int accountNo);
}
