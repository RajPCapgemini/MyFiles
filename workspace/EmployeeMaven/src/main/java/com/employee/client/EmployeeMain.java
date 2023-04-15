package com.employee.client;

import com.employee.bean.*;
import com.employee.exception.InvalidEmployeeIdException;
import com.employee.util.*;
import java.util.*;
import com.employee.services.*;

public class EmployeeMain {
	private EmployeeService employeeServiceImpl;
	public EmployeeMain() {
		employeeServiceImpl=new EmployeeServiceImpl();
	}
	public static void main(String[] args) {
		EmployeeMain obj=new EmployeeMain();
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Enter\n1: show employee details\n2: show salary\n3: show bonus\n5: exit");
			choice=scanner.nextInt();
			switch(choice) {
				case 1:{
					System.out.print("Enter employee Id: ");
					int eId=scanner.nextInt();
					try {
						obj.employeeServiceImpl.display(eId);
					} catch (InvalidEmployeeIdException e) {
						System.out.println("Error: "+e.getMessage());
					}
					break;
				}
				case 2:{
					System.out.print("Enter employee Id: ");
					int eId=scanner.nextInt();
					try {
						obj.employeeServiceImpl.showSalary(eId);
					} catch (InvalidEmployeeIdException e) {
						System.out.println("Error: "+e.getMessage());
					}
					break;
				}
				case 3:{
					System.out.print("Enter employee Id: ");
					int eId=scanner.nextInt();
					try {
						obj.employeeServiceImpl.getBonus(eId);
					} catch (InvalidEmployeeIdException e) {
						System.out.println("Error: "+e.getMessage());
					}
					break;
				}
				case 4:{
					obj.employeeServiceImpl.showEmployees();
					break;
				}
				case 5:{
					choice=0;
					break;
				}
			}
			
		}while(choice!=0);
	}

}
