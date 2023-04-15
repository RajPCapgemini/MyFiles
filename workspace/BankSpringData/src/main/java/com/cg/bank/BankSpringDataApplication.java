package com.cg.bank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cg.bank.exception.*;
import com.cg.bank.pojos.*;
import com.cg.bank.service.*;

@SpringBootApplication
public class BankSpringDataApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BankSpringDataApplication.class, args);
		BankService bankService = context.getBean(BankService.class, "bankService");
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		do {
			System.out.print("1: Create Account\n2: Account Services\n10: Exit\n->");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.print("Enter First Name: ");
				String firstName = sc.next();
				if (!firstName.matches("^[a-zA-Z]+$")) {
					System.out.println("Invalid input");
					break;
				}
				System.out.print("Enter Last Name: ");
				String lastName = sc.next();
				if (!lastName.matches("^[a-zA-Z]+$")) {
					System.out.println("Invalid input");
					break;
				}
				Account account = bankService.addAccount(firstName, lastName);
				System.out.println("Your Bank details are: \nName: " + firstName + " " + lastName + "\nAccount No: "
						+ account.getAccountNo() + "\nBalance: " + account.getBalance());
				break;
			}
			case 2: {
				boolean innerLoop = true;
				while (innerLoop) {
					System.out.print("Enter Account No: ");
					int accountNo = sc.nextInt();
					if (!bankService.accountExists(accountNo)) {
						System.out.println("Account does not exists");
						break;
					}
					System.out.print(
							"1: Show Balance\n2: Withdraw\n3: Deposit\n4: Transfer Fund\n5: Show last 10 Transactions\n6: Show transactions within date\n7: Show last N transactions\n8: Exit\n->");
					int option = sc.nextInt();

					switch (option) {
					case 1: {

						try {
							System.out.println(bankService.showBalance(accountNo));
						} catch (InvalidAccountException e) {
							System.out.println(e);
						}
						break;
					}
					case 2: {
						System.out.print("Enter Amount: ");
						double amount = sc.nextDouble();
						try {
							System.out.println("Available balance: Rs " + bankService.withdraw(accountNo, amount));
						} catch (InvalidAccountException e) {
							System.out.println(e);
						} catch (InsufficientFundException e) {
							System.out.println(e);
						} catch (NegativeAmountException e) {
							System.out.println(e);
						} catch (HighValueTransactionException e) {
							System.out.println(e);
						}
						break;
					}
					case 3: {
						System.out.print("Enter Amount: ");
						double amount = sc.nextDouble();
						try {
							System.out.println("Available balance: Rs " + bankService.deposit(accountNo, amount));
						} catch (InvalidAccountException e) {
							System.out.println(e);
						} catch (NegativeAmountException e) {
							System.out.println(e);
						} catch (HighValueTransactionException e) {
							System.out.println(e);
						} catch (InsufficientFundException e) {
							e.printStackTrace();
						}
						break;
					}
					case 4: {
						int senderAcc = accountNo;
						System.out.print("Enter Receiver Account No: ");
						int receiverAcc = sc.nextInt();
						System.out.print("Enter Amount: ");
						double amount = sc.nextDouble();
						try {
							System.out.println(bankService.fundTransfer(senderAcc, receiverAcc, amount));
						} catch (InvalidAccountException e) {
							System.out.println(e);
						} catch (NegativeAmountException e) {
							System.out.println(e);
						} catch (HighValueTransactionException e) {
							System.out.println(e);
						} catch (InsufficientFundException e) {
							e.printStackTrace();
						}
						break;
					}
					case 5: {
						List<Transaction> transactions;
						try {
							transactions = bankService.last10Transaction(accountNo);
							if (transactions.size() == 0) {
								System.out.println("No Transactions");
								break;
							}
							Iterator<Transaction> it = transactions.iterator();
							System.out.println("Transactions-");
							while (it.hasNext()) {
//								System.out.println(it.next());
								Transaction currTransaction = it.next();
								int tid = currTransaction.getTransactionId();
								String ttype = currTransaction.getTransactionType();
								Date date = currTransaction.getTransactionDate();
								Double bal = currTransaction.getTransactionBalance();
								Double amt = currTransaction.getTransactionAmount();
								System.out.print("Id: " + tid + "--" + ttype + " of amount  Rs " + amt + " on " + date
										+ ". Balance: Rs " + bal + "\n");
							}
						} catch (InvalidAccountException e) {
							System.out.println(e);
						}

						break;
					}
					case 6: {
						System.out.print("Enter start date(dd/MM/yy): ");
						String str = sc.next();
						Date startDate = null, endDate = null;
						try {
							startDate = new SimpleDateFormat("dd/MM/yy").parse(str);
						} catch (ParseException e) {
							System.out.println(e);
						}
						System.out.print("Enter end date(dd/MM/yy): ");
						str = sc.next();
						try {
							endDate = new SimpleDateFormat("dd/MM/yy").parse(str);
						} catch (ParseException e) {
							System.out.println(e);
						}
						try {
							List<Transaction> transactions = bankService.transactionWithinDate(accountNo, startDate,
									endDate);
							if (transactions.size() == 0) {
								System.out.println("No Transactions");
								break;
							}
							Iterator<Transaction> it = transactions.iterator();
							System.out.println("Transactions-");
							while (it.hasNext()) {
								Transaction currTransaction = it.next();
								int tid = currTransaction.getTransactionId();
								String ttype = currTransaction.getTransactionType();
								Date date = currTransaction.getTransactionDate();
								Double bal = currTransaction.getTransactionBalance();
								Double amt = currTransaction.getTransactionAmount();
								System.out.print("Id: " + tid + "--" + ttype + " of amount  Rs " + amt + " on " + date
										+ ". Balance: Rs " + bal + "\n");
							}
						} catch (InvalidAccountException e) {
							System.out.println(e);
						} catch (InvalidDateException e) {
							System.out.println(e);
						}
						break;
					}
					case 7: {
						System.out.print("Enter value of n: ");
						int n = sc.nextInt();
						try {
							System.out.println("Transactions-");
							List<Transaction> transactions = bankService.lastNTransaction(accountNo, n);
							if (transactions.size() == 0) {
								System.out.println("No Transactions");
								break;
							}
							Iterator<Transaction> it = transactions.iterator();
							System.out.println("Transactions-");
							while (it.hasNext()) {
								Transaction currTransaction = it.next();
								int tid = currTransaction.getTransactionId();
								String ttype = currTransaction.getTransactionType();
								Date date = currTransaction.getTransactionDate();
								Double bal = currTransaction.getTransactionBalance();
								Double amt = currTransaction.getTransactionAmount();
								System.out.print("Id: " + tid + "--" + ttype + " of amount  Rs " + amt + " on " + date
										+ ". Balance: Rs " + bal + "\n");
							}
						} catch (InvalidAccountException e) {
							System.out.println(e);
						}
						break;
					}
					case 8: {
						bankService.deleteAccount(accountNo);
						if (!bankService.accountExists(accountNo)) {
							System.out.println("Deleted");
						} else {
							System.out.println("Error in deleting");
						}
						break;
					}
					}

				}
				break;
			}
			case 10: {
				loop = false;
			}
			}
		} while (loop);

	}
}
