package com.BankJdbc.dao;

import com.BankJdbc.bean.*;
import com.BankJdbc.util.AccountUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class BankDaoImpl implements BankDaoInt{
	private AccountUtil accountUtil;
	static Connection connection=null;
	static PreparedStatement ps=null;
	PreparedStatement ps2=null;
	ResultSet resultSetTransaction;
	public BankDaoImpl() throws ClassNotFoundException, SQLException,NullPointerException, FileNotFoundException, IOException {
		accountUtil = new AccountUtil();
		connection = accountUtil.getMyConnection();
	}
	public void save(Account account) throws FileNotFoundException, IOException, SQLException {
		String query = "UPDATE account SET balance=? WHERE accountNo=?";
		ps = connection.prepareStatement(query);
		ps.setDouble(1, account.getBalance());
		ps.setInt(2, account.getAccountNo());
		ps.executeUpdate();
		
		String updateTransactions="INSERT INTO transaction(tid,ttype,tdate,tamount,tbalance,accountNo) VALUES(?,?,?,?,?,?)";
		ps2=connection.prepareStatement(updateTransactions);
		Transaction transaction = account.getTransactions().get(account.getTransactions().size()-1);
		ps2.setInt(1, transaction.getTransactionId());
		ps2.setString(2, transaction.getTransactionType());
		ps2.setDate(3, new java.sql.Date(transaction.getDate().getTime()) );
		ps2.setDouble(4, transaction.getAmount());
		ps2.setDouble(5, transaction.getBalance());
		ps2.setInt(6, account.getAccountNo());
		ps2.executeUpdate();
	}

	public Account getByAccountNo(int accountNo) throws FileNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
			String query = "SELECT accountNo,balance,custid,firstname,lastname FROM account INNER JOIN customer ON account.custid=customer.customerId WHERE accountNo=?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, accountNo);
			List<Transaction> transactions=new ArrayList<Transaction>();
			String fetchTransactions="SELECT tid,ttype,tdate,tamount,tbalance,accountno FROM transaction WHERE accountno=?";
			ps2= connection.prepareStatement(fetchTransactions);
			ps2.setInt(1, accountNo);
			resultSetTransaction = ps2.executeQuery();
			while(resultSetTransaction.next()) {
				Transaction transac = new Transaction(resultSetTransaction.getInt("tid"),resultSetTransaction.getDate("tdate"),resultSetTransaction.getString("ttype"),resultSetTransaction.getDouble("tamount"),resultSetTransaction.getDouble("tbalance"));
				transactions.add(transac);
			}
			ResultSet resultSetAcc = ps.executeQuery();
			while(resultSetAcc.next()) {
				int accNo = resultSetAcc.getInt("accountNo");
				double bal = resultSetAcc.getDouble("balance");
				int customerId = resultSetAcc.getInt("custid");
				String fName = resultSetAcc.getString("firstname");
				String lName = resultSetAcc.getString("lastname");
				Account account = new Account(accNo,bal,new Customer(customerId,fName,lName),transactions);
				
				return account;
			}
			
		return null;
	}
	public int getTransactionId() throws SQLException {
		String query="SELECT MAX(tid) AS tid FROM transaction";
		PreparedStatement ps=connection.prepareStatement(query);
		ResultSet resultSet=ps.executeQuery();
		if(resultSet.next()) {
			int tid=resultSet.getInt("tid");
			return tid+1;
		}else {
			return 100001;
		}
	}
	public void closeConn() throws Exception{
		System.out.println("closed");
			connection.close();
		
	}

}
