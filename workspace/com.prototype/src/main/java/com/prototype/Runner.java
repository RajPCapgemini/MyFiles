package com.prototype;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeRecord er = new EmployeeRecord(100,"raj",5000);
		System.out.println(er);
		EmployeeRecord er2 = (EmployeeRecord) er.getClone();
		System.out.println(er2);
	}

}
