package com.BankJdbc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class AccountUtil {
	Properties properties;
	Connection connection = null;

	public Connection getMyConnection()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, NullPointerException {

		properties = new Properties();
		properties.load(new FileInputStream("config\\configuration.properties"));
		Class.forName(properties.getProperty("driverName"));
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");

		connection = DriverManager.getConnection(url, user, password);
		return connection;

	}

	public void createTables() throws FileNotFoundException, IOException, SQLException {
		PreparedStatement preparedStatement = null;

		String createCustomer = "CREATE TABLE IF NOT EXISTS customer(customerId INT PRIMARY KEY,firstname VARCHAR(255),lastname VARCHAR(255));";
		preparedStatement = connection.prepareStatement(createCustomer);
		preparedStatement.executeUpdate();

		String createAccount = "CREATE TABLE IF NOT EXISTS account(accountNo INT PRIMARY KEY,balance FLOAT,custid INT, FOREIGN KEY(custid) REFERENCES customer(customerid));";
		preparedStatement = connection.prepareStatement(createAccount);
		preparedStatement.executeUpdate();

		String createTransaction = "CREATE TABLE IF NOT EXISTS transaction(tid INT PRIMARY KEY,ttype VARCHAR(255),tdate DATE,tamount FLOAT,tbalance FLOAT,accountNo INT, FOREIGN KEY(accountNo) REFERENCES account(accountNo));";
		preparedStatement = connection.prepareStatement(createTransaction);
		preparedStatement.executeUpdate();
	}

	public void insertData()
			throws FileNotFoundException, IOException, ClassNotFoundException, NullPointerException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getMyConnection();

		String insertIntoCustomer = "INSERT INTO customer(customerid,firstname,lastname) VALUES(1,\"R\",\"P\"),(2,\"A\",\"S\"),(3,\"S\",\"B\"),(4,\"R\",\"B\"),(5,\"B\",\"S\"),(6,\"B\",\"C\"),(7,\"M\",\"C\"),(8,\"B\",\"K\"),(9,\"F\",\"K\"),(10,\"C\",\"T\");";
		preparedStatement = connection.prepareStatement(insertIntoCustomer);
		preparedStatement.executeUpdate();

		String insertIntoAccount = "INSERT INTO account(accountNo,balance,custid) VALUES(101,10000,1),(102,15000,2),(103,10500,3),(104,10000,4),(105,20000,5),(106,12000,6),(107,14500,7),(108,14000,8),(109,60000,9),(110,88000,10);";
		preparedStatement = connection.prepareStatement(insertIntoAccount);
		preparedStatement.executeUpdate();
	}

	public AccountUtil()
			throws FileNotFoundException, IOException, SQLException, ClassNotFoundException, NullPointerException {
		connection = getMyConnection();
		createTables();
//		insertData();
	}
}
