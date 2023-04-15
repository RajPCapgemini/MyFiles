package com.client;

import java.util.Scanner;

import com.service.*;

public class JdbcTest {
	private JdbcInt serviceImpl;
	JdbcTest(){
		serviceImpl = new JdbcImpl();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcTest obj = new JdbcTest();
		Scanner sc = new Scanner(System.in);
		int choice=-1;
		do {
			System.out.println("1: Show balance\n2: Deposit\n3: withdraw\n10: Exit");
			choice=sc.nextInt();
			switch(choice) {
			case 1:{
				int accNo = sc.nextInt();
				System.out.println("balance: "+obj.serviceImpl.showBalance(accNo));
				break;
			}
			case 2:{
				int accNo = sc.nextInt();
				double amount = sc.nextDouble();
				obj.serviceImpl.deposit(accNo, amount);
				System.out.println("Updated balance: "+obj.serviceImpl.showBalance(accNo));
				break;
			}
			case 3:{
				int accNo = sc.nextInt();
				double amount = sc.nextDouble();
				obj.serviceImpl.withdraw(accNo, amount);
				System.out.println("Updated balance after: "+obj.serviceImpl.showBalance(accNo));
				break;
			}
			case 10:{
				choice=0;
				break;
			}
			default:{
				System.out.println("Invalid choice");
			}
			}
		}while(choice!=0);
	}

}
