package com.bankServer.dao;

import com.bankServer.bean.*;

public interface BankServerDao {
	public Account getByAccountNo(int accountNo);
}
