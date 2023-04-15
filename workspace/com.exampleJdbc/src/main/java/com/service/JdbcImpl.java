package com.service;

import com.bean.*;
import com.dao.*;

public class JdbcImpl implements JdbcInt{
	private JdbcDaoInt daoImpl;
	public JdbcImpl() {
		daoImpl = new JdbcDaoImpl();
	}
	public double showBalance(int accountNo) {
		// TODO Auto-generated method stub
		Account account = daoImpl.getById(accountNo);
		return account.getBalance();
	}
	public double deposit(int accountNo,double amount) {
		// TODO Auto-generated method stub
		Account account = daoImpl.getById(accountNo);
		account.setBalance(account.getBalance()+amount);
		daoImpl.save(account);
		return account.getBalance();
	}
	public double withdraw(int accountNo,double amount) {
		Account account = daoImpl.getById(accountNo);
		account.setBalance(account.getBalance()-amount);
		daoImpl.save(account);
		return account.getBalance();
	}

}
