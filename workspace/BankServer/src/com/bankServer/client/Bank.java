package com.bankServer.client;

import com.bankServer.bean.*;
import com.bankServer.services.*;
import java.util.*;

public class Bank {
	private BankServerService bankServerService;
	public Bank() {
		bankServerService=new BankServerServiceImpl();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Bank bank= new Bank();
		int choice;
		do {
			System.out.println("1 to show balance\n2 to withdraw money\n3 to deposit money\n4 to display last 10 transactions\n5 to transfer fund\n6 to exit");
			choice=scanner.nextInt();
			switch(choice) {
				case 1:{
					System.out.print("Enter account No: ");
					int accountNo=scanner.nextInt();
					System.out.println(bank.bankServerService.showBalance(accountNo));
					break;
				}
				case 2:{
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					System.out.print("Enter amount: ");
					double amount=scanner.nextDouble();
					bank.bankServerService.withdraw(accountNo, amount);
					break;
				}
				case 3:{
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					System.out.print("Enter amount: ");
					double amount=scanner.nextDouble();
					bank.bankServerService.deposit(accountNo, amount);
					break;
				}
				case 4:{
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					System.out.println( bank.bankServerService.display(accountNo));
					break;
				}
				case 5:{
//					System.out.print("Enter your account No: ");
//					int senderAcc = scanner.nextInt();
					System.out.print("Enter receiver account No: ");
					int receiverAcc = scanner.nextInt();
					System.out.print("Enter amount: ");
					double amount=scanner.nextDouble();
					bank.bankServerService.fundTransfer(receiverAcc, amount);
					break;
				}
				case 6:{
					choice=0;
					break;
				}
			}
		}while(choice!=0);

	}

}
