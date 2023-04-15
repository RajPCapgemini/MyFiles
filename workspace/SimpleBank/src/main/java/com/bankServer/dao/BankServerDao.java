package com.bankServer.dao;

import com.bankServer.bean.*;
import com.bankServer.exception.*;

public interface BankServerDao {
	public Account getByAccountNo(int accountNo);
	public double getMinimumBalance();
	public void inactiveAccounts();
	public int getTransactionArraySize();
}
