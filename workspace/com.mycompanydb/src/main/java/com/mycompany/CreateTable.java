package com.mycompany;

import java.sql.*;

public class CreateTable {
	static Connection connection;
	static PreparedStatement preparedStatement;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mycompany";
			String user = "root";
			String password = "root";
			
			try {
				connection = DriverManager.getConnection(url,user,password);
				String query="CREATE TABLE IF NOT EXISTS employee(eid INT(3) PRIMARY KEY,ename VARCHAR(20),doj DATE,esal FLOAT(7,2),edept INT(2);";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.executeUpdate(query);
				
				String query2="CREATE TABLE IF NOT EXISTS dept(dno INT(2),dname VARCHAR(15),dloc VARCHAR(20));";
				preparedStatement = connection.prepareStatement(query2);
				preparedStatement.executeUpdate(query2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
