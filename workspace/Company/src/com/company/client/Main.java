package com.company.client;

import com.company.exception.InvalidIdException;
import com.company.services.CompanyService;
import com.company.services.CompanyServiceImpl;
import java.util.*;

public class Main {
	private CompanyService companyServiceImpl;
	public Main() {
		companyServiceImpl=new CompanyServiceImpl();
	}
	public static void main(String [] args) {
		Main employee = new Main();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter\n1 for Get Name \n2 for Get Salary");
		int choice=scanner.nextInt();
		do {
			switch(choice) {
				case 1:{
					System.out.print("Enter Employee Id: ");
					int eId = scanner.nextInt();
					try {
					System.out.println("Name of Employee is "+employee.companyServiceImpl.getEmployeeName(eId));
					}catch(InvalidIdException e) {
						System.out.println(e);
					}
					break;
				}
				case 2:{
					System.out.print("Enter Employee Id: ");
					int eId = scanner.nextInt();
					try {
					System.out.println("Salary of Employee is "+employee.companyServiceImpl.getEmployeeSalary(eId));
					}catch(InvalidIdException e) {
						System.out.println(e);
					}
					break;
				}
				default:{
					System.out.println("Invalid choice entered");
				}
			}
			System.out.println("Enter 0 to exit OR\nEnter choice: ");
			choice=scanner.nextInt();
		}while(choice!=0);
		scanner.close();
	}
}
