package com.factory;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeFactory ef = new EmployeeFactory();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee type: ");
		String employeeType = sc.next();
		Employee emp = ef.getEmployee(EmployeeEnum.EmployeeType.MANAGER);
		System.out.println(emp);
		System.out.println("Net Salary: "+emp.computeSalary());
	}

}
