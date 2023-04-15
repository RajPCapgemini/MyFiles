package com.bankJPA.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankJPA.exception.HighValueTransactionException;
import com.bankJPA.exception.InsufficientFundException;
import com.bankJPA.exception.InvalidAccountException;
import com.bankJPA.exception.InvalidDateException;
import com.bankJPA.exception.NegativeAmountException;
import com.bankJPA.pojos.*;
import com.bankJPA.service.*;

public class BankJPATest {
	private BankJPAServiceInt bankService;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankBeans.xml");
		BankJPATest bank=null;
		Scanner sc=null;
		try {
		bank = new BankJPATest();
		bank.bankService=context.getBean(BankJPAServiceInt.class,"bankService");
		sc = new Scanner(System.in);
		int choice=-1;
		do {
			System.out.print("1: Create Account\n2: Account Services\n10: Exit\n->");
			choice= sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.print("Enter First Name: ");
				String firstName=sc.next();
				System.out.print("Enter Last Name: ");
				String lastName=sc.next();
				Account account = bank.bankService.addAccount(firstName, lastName);
				System.out.println("Your Bank details are: \nName: "+firstName+" "+lastName+"\nAccount No: "+account.getAccountNo()+"\nBalance: "+account.getBalance());
				break;
			}
			case 2:{
				System.out.print("Enter Account No: ");
				int accountNo=sc.nextInt();
				System.out.print("1: Show Balance\n2: Withdraw\n3: Deposit\n4: Transfer Fund\n5: Show last 10 Transactions\n6: Show transactions within date\n7: Show last N transactions\n8: Exit\n->");
				int option=sc.nextInt();
				
				switch(option) {
				case 1:{
					
					try {
						System.out.println(bank.bankService.showBalance(accountNo));
					} catch (InvalidAccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} 
					break;
				}
				case 2:{
					System.out.print("Enter Amount: ");
					double amount=sc.nextDouble();
					try {
						System.out.println("Available balance: Rs "+bank.bankService.withdraw(accountNo, amount));
					} catch (InvalidAccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (InsufficientFundException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (NegativeAmountException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (HighValueTransactionException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					break;
				}
				case 3:{
					System.out.print("Enter Amount: ");
					double amount=sc.nextDouble();
					try {
						System.out.println("Available balance: Rs "+bank.bankService.deposit(accountNo, amount));
					} catch (InvalidAccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (NegativeAmountException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (HighValueTransactionException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (InsufficientFundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 4:{
					int senderAcc=accountNo;
					System.out.print("Enter Receiver Account No: ");
					int receiverAcc=sc.nextInt();
					System.out.print("Enter Amount: ");
					double amount=sc.nextDouble();
					try {
						System.out.println(bank.bankService.fundTransfer(senderAcc, receiverAcc, amount));
					} catch (InvalidAccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (NegativeAmountException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (HighValueTransactionException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (InsufficientFundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 5:{
					List<Transaction> transactions;
					try {
						transactions = bank.bankService.last10Transaction(accountNo);
						if(transactions.size()==0) {
							System.out.println("No Transactions");
							break;
						}
						Iterator<Transaction> it=transactions.iterator();
						System.out.println("Transactions-");
						while(it.hasNext()) {
//							System.out.println(it.next());
							Transaction currTransaction = it.next();
							int tid=currTransaction.getTransactionId();
							String ttype=currTransaction.getTransactionType();
							Date date = currTransaction.getTransactionDate();
							Double bal = currTransaction.getTransactionBalance();
							Double amt = currTransaction.getTransactionAmount();
							System.out.print("Id: "+tid+"--"+ttype+" of amount  Rs "+amt+" on "+date+". Balance: Rs "+bal+"\n");
						}
					} catch (InvalidAccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					
					break;
				}
				case 6:{
					System.out.print("Enter start date(dd/MM/yy): ");
					String str=sc.next();
					Date startDate = null,endDate=null;
					try {
						startDate = new SimpleDateFormat("dd/MM/yy").parse(str);
					} catch (ParseException e) {
						System.out.println(e);
					}
					System.out.print("Enter end date(dd/MM/yy): ");
					str=sc.next();
					try {
						endDate = new SimpleDateFormat("dd/MM/yy").parse(str);
					} catch (ParseException e) {
						System.out.println(e);
					}
					try {
						List<Transaction> transactions = bank.bankService.transactionWithinDate(accountNo, startDate, endDate);
						if(transactions.size()==0) {
							System.out.println("No Transactions");
							break;
						}
						Iterator<Transaction> it = transactions.iterator();
						System.out.println("Transactions-");
						while(it.hasNext()) {
//							System.out.println(it.next());
							Transaction currTransaction = it.next();
							int tid=currTransaction.getTransactionId();
							String ttype=currTransaction.getTransactionType();
							Date date = currTransaction.getTransactionDate();
							Double bal = currTransaction.getTransactionBalance();
							Double amt = currTransaction.getTransactionAmount();
							System.out.print("Id: "+tid+"--"+ttype+" of amount  Rs "+amt+" on "+date+". Balance: Rs "+bal+"\n");
						}
					} catch (InvalidAccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (InvalidDateException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					break;
				}
				case 7:{
					System.out.print("Enter value of n: ");
					int n=sc.nextInt();
					try {
						System.out.println("Transactions-");
						List<Transaction> transactions=bank.bankService.lastNTransaction(accountNo, n);
						if(transactions.size()==0) {
							System.out.println("No Transactions");
							break;
						}
						Iterator<Transaction> it = transactions.iterator();
						System.out.println("Transactions-");
						while(it.hasNext()) {
//							System.out.println(it.next());
							Transaction currTransaction = it.next();
							int tid=currTransaction.getTransactionId();
							String ttype=currTransaction.getTransactionType();
							Date date = currTransaction.getTransactionDate();
							Double bal = currTransaction.getTransactionBalance();
							Double amt = currTransaction.getTransactionAmount();
							System.out.print("Id: "+tid+"--"+ttype+" of amount  Rs "+amt+" on "+date+". Balance: Rs "+bal+"\n");
						}
					} catch (InvalidAccountException e) {
						System.out.println(e);
					}
					break;
				}
				}
				break;
			}
			
			case 10:
				choice=0;
			}
		}while(choice!=0);
		}finally {
			sc.close();
			if(bank.bankService instanceof  BankJPAServiceInt) {
				BankJPAServiceImpl newBankService = (BankJPAServiceImpl)bank.bankService;
				newBankService.closeResources();
			}
		}

	}

}
