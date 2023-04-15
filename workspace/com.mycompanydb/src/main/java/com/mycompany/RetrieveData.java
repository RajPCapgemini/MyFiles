package com.mycompany;

import java.sql.*;

public class RetrieveData {
	static Connection connection;
	static PreparedStatement preparedStatement;
	static ResultSet resultSet;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/mycompany";
			String user = "root";
			String password = "root";
			
			try {
				connection = DriverManager.getConnection(url,user,password);
				String q = "SELECT employee.*,dept.* FROM employee JOIN dept on employee.edept=dept.dno;";
				preparedStatement = connection.prepareStatement(q);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int eid=resultSet.getInt("eid");
					int dno=resultSet.getInt("dno");
					System.out.println(eid+ " " + dno);
				}
				
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
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
