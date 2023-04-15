package com.bank.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.bank.bean.*;
import com.bank.client.*;
import com.bank.exception.*;
import com.bank.service.*;

public class BankDemo {
	private BankServiceInterface bankServiceImpl;
	BankDemo(){
		bankServiceImpl=new BankServiceImpl();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BankDemo bank= new BankDemo();
		int choice;
		do {
			System.out.print("\n1: show balance\n2: withdraw money\n3: deposit money\n4: display last 10 transactions\n5: transfer fund\n6: display transactions between a duration\n7: check if account is inactive for a year\n8: show all inactive accounts\n9: display last N transactions\n10: exit\n:");
			choice=scanner.nextInt();
			switch(choice) {
				case 1:{
					System.out.print("Enter account No: ");
					int accountNo=scanner.nextInt();
					try {
					System.out.println("Current balance: "+bank.bankServiceImpl.showBalance(accountNo));
					}catch(InvalidAccountException e) {
						System.out.println(e);
					}
					break;
				}
				case 2:{
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					System.out.print("Enter amount: ");
					double amount=scanner.nextDouble();
					if(amount<0) {
						System.out.println("Negative amount not allowed");
						break;
					}
					try {
					System.out.println("Updated balance: "+bank.bankServiceImpl.withdraw(accountNo, amount)); 
					}catch(InvalidAccountException e) {
						System.out.println(e);
					}catch(InsufficientFundException e){
						System.out.println(e);
					}catch(NegativeAmountException e) {
						System.out.println(e);
					}
					break;
				}
				case 3:{
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					System.out.print("Enter amount: ");
					double amount=scanner.nextDouble();
					try {
					System.out.println("Updated balance: "+bank.bankServiceImpl.deposit(accountNo, amount));
					}catch(InvalidAccountException e) {
						System.out.println(e);
					}catch(NegativeAmountException e) {
						System.out.println(e);
					}
					break;
				}
				case 4:{
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					try {
					System.out.println( bank.bankServiceImpl.display(accountNo));
					}catch(InvalidAccountException e) {
						System.out.println(e);
					}
					break;
				}
				case 5:{
					System.out.print("Enter your account No: ");
					int senderAcc = scanner.nextInt();
					System.out.print("Enter receiver account No: ");
					int receiverAcc = scanner.nextInt();
					System.out.print("Enter amount: ");
					double amount=scanner.nextDouble();
					try {
						System.out.println(bank.bankServiceImpl.fundTransfer(senderAcc,receiverAcc, amount));
					}catch(NegativeAmountException e) {
						System.out.println(e);
					}
					catch(InvalidAccountException e) {
						System.out.println(e);
					}catch(InsufficientFundException e) {
						System.out.println(e);
					}
					break;
				}
				case 6:{
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					System.out.print("Enter start date(dd/MM/yy): ");
					String str=scanner.next();
					Date startDate = null,endDate=null;
					try {
						startDate = new SimpleDateFormat("dd/MM/yy").parse(str);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					System.out.print("Enter end date(dd/MM/yy): ");
					str=scanner.next();
					try {
						endDate = new SimpleDateFormat("dd/MM/yy").parse(str);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					try {
						System.out.println( bank.bankServiceImpl.displayTransactionWithinDate(accountNo,startDate,endDate));
					} catch (InvalidAccountException e) {
						e.printStackTrace();
					}catch (InvalidDateException e) {
						System.out.println(e);
					}
					break;
				}
				case 7:{
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					try {
						if(bank.bankServiceImpl.isInactive(accountNo)) {
							System.out.println("Account Inactive");
						}
						else {
							System.out.println("Account active");
						}
					} catch (InvalidAccountException e) {
						e.printStackTrace();
					}
					break;
				}
				case 8:{
					bank.bankServiceImpl.inactiveAccounts();
					break;
				}
				case 9:{
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					System.out.print("Enter value of n: ");
					int n=scanner.nextInt();
					try {
						String transactions=bank.bankServiceImpl.lastNTransactions(accountNo, n);
						System.out.println(transactions);
					} catch (InvalidAccountException e) {
						e.printStackTrace();
					}
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
