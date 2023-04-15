package com.dao;

import com.bean.*;
import com.util.AccountUtil;

import java.sql.*;

public class JdbcDaoImpl implements JdbcDaoInt{
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	AccountUtil accountUtil;
	public JdbcDaoImpl() {
		accountUtil = new AccountUtil();
	}
	public boolean save(Account account) {
		
		try {
			connection  = accountUtil.getMyConnection();
			int accid=account.getAccid();
			double balance=account.getBalance();
			String query="UPDATE account SET balance=? WHERE accid=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, balance);
			preparedStatement.setInt(2, accid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public Account getById(int accountNo) {
		// TODO Auto-generated method stub
		try {
			connection  = accountUtil.getMyConnection();
			String query = "SELECT accid,balance FROM account WHERE accid=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, accountNo);
			resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				int accid=resultSet.getInt("accid");
				double balance = resultSet.getDouble("balance");
				Account account = new Account(accid,balance);
				return account;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
