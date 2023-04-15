package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateData {
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
				String addFK = "ALTER TABLE employee ADD FOREIGN KEY(edept) REFERENCES dept(dno);";
				preparedStatement = connection.prepareStatement(addFK);
				preparedStatement.executeUpdate();
				
				String insertData = "INSERT INTO employee(eid,ename,doj,esal,edept) VALUES(101,\"Raj\",'2023-01-31',50000,5);";
				preparedStatement = connection.prepareStatement(insertData);
				preparedStatement.executeUpdate();
				
				insertData = "INSERT INTO employee(eid,ename,doj,esal,edept) VALUES(102,\"Raja\",null,40000,1)";
				preparedStatement = connection.prepareStatement(insertData);
				preparedStatement.executeUpdate();
				
				insertData = "INSERT INTO employee(eid,ename,doj,esal,edept) VALUES(103,\"Raju\",null,30000,3)";
				preparedStatement = connection.prepareStatement(insertData);
				preparedStatement.executeUpdate();
				
				insertData = "INSERT INTO employee(eid,ename,doj,esal,edept) VALUES(104,\"Rajaram\",'2023-02-28',20000,1);";
				preparedStatement = connection.prepareStatement(insertData);
				preparedStatement.executeUpdate();
				
				insertData = "INSERT INTO employee(eid,ename,doj,esal,edept) VALUES(105,\"Rajshri\",null,10000,3);";
				preparedStatement = connection.prepareStatement(insertData);
				preparedStatement.executeUpdate();
				
				insertData = "INSERT INTO employee(eid,ename,doj,esal,edept) VALUES(106,\"Rajput\",null,60000,2);";
				preparedStatement = connection.prepareStatement(insertData);
				preparedStatement.executeUpdate();
				
				insertData = "INSERT INTO employee(eid,ename,doj,esal,edept) VALUES(107,\"Rajat\",'2023-01-01',70000,2);";
				preparedStatement = connection.prepareStatement(insertData);
				preparedStatement.executeUpdate();
				
				insertData = "INSERT INTO employee(eid,ename,doj,esal,edept) VALUES(108,\"Raji\",null,80000,5);";
				preparedStatement = connection.prepareStatement(insertData);
				preparedStatement.executeUpdate();
				
				insertData = "INSERT INTO employee(eid,ename,doj,esal,edept) VALUES(109,\"Razia\",'2023-01-02',90000,4);";
				preparedStatement = connection.prepareStatement(insertData);
				preparedStatement.executeUpdate();
				
				insertData = "INSERT INTO employee(eid,ename,doj,esal,edept) VALUES(110,\"Rakhi\",null,55000,4);";
				preparedStatement = connection.prepareStatement(insertData);
				preparedStatement.executeUpdate();
				
				insertData = "INSERT INTO employee(eid,ename,doj,esal,edept) VALUES(110,\"Rakhi\",null,55000,4);";
				preparedStatement = connection.prepareStatement(insertData);
				preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
