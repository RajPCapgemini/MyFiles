package com.util;

import java.sql.*;

public class AccountUtil {
// getMYConnection
// table creation
// insert record
	
	public Connection getMyConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mybank";
			String user="root";
			String pass="root";
			
			connection = DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
		
	}
	public AccountUtil(){
		Connection connection = getMyConnection();
		//create table
		//insert data
		
	}
}
