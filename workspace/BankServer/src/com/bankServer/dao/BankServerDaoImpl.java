package com.bankServer.dao;

import com.bankServer.bean.*;
import com.bankServer.util.*;

public class BankServerDaoImpl implements BankServerDao{
	private AccountUtil accountUtil;
	public BankServerDaoImpl() {
		accountUtil=new AccountUtil();
	}

	@Override
	public Account getByAccountNo(int accountNo) {
		// TODO Auto-generated method stub
		Account accounts[] = accountUtil.getAccounts();
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i].getAccountNo()==accountNo) {
				return accounts[i];
			}
		}
		return null;
	}

}
