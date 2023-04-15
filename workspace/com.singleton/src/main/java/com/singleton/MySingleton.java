package com.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySingleton {
	private static MySingleton instance = null;
	private static Connection conn = null;
	
	//restricting instantiation of class
	private MySingleton() {
		
	}
	
	public static MySingleton getInstance() {
		if(instance==null)
			instance = new MySingleton();
		return instance;
	}
	
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		if(conn==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/design_pattern";
			String user="root";
			String password="root";
			conn = DriverManager.getConnection(url, user, password);
		}
		return conn;
	}
}
