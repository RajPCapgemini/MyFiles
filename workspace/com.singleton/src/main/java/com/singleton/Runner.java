package com.singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Runner {

	public static void main(String[] args) {
//		MySingleton instance = MySingleton.getInstance();
//		System.out.println(instance);
//		
//		MySingleton instance1 = MySingleton.getInstance();
//		System.out.println(instance1);
		
		MySingleton instance = MySingleton.getInstance();
		long startTime,endTime;
		try {
			startTime = System.currentTimeMillis();
			Connection conn = instance.getMyConnection();
			endTime= System.currentTimeMillis();
			String query="CREATE TABLE IF NOT EXISTS table1(id INT,name VARCHAR(255))";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.executeUpdate();
			System.out.println("Time taken: "+(endTime-startTimeo));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("created===>");
		startTime = System.currentTimeMillis();
		try {
			Connection conn1 = instance.getMyConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time taken: "+(endTime-startTime));
	}

}
