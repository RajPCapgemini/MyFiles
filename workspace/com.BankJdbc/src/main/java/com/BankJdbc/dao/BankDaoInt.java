package com.BankJdbc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.BankJdbc.bean.*;

public interface BankDaoInt {
	public void save(Account account) throws FileNotFoundException, IOException, SQLException;
	public Account getByAccountNo(int accountNo) throws FileNotFoundException, IOException, SQLException;
	public int getTransactionId() throws Exception;
}
