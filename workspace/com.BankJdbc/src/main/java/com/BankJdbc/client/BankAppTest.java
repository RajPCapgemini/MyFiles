package com.BankJdbc.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.BankJdbc.exception.InsufficientFundException;
import com.BankJdbc.exception.InvalidAccountException;
import com.BankJdbc.exception.InvalidDateException;
import com.BankJdbc.exception.NegativeAmountException;
import com.BankJdbc.service.BankServiceImpl;
import com.BankJdbc.service.BankServiceInt;

public class BankAppTest {
	private BankServiceInt bankServiceImpl;

	BankAppTest()
			throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException, IOException {
		bankServiceImpl = new BankServiceImpl();
	}

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		BankAppTest bank = null;
		try {
			scanner = new Scanner(System.in);
			bank = new BankAppTest();
			int choice;
			do {
				System.out.print(
						"\n1: Show balance\n2: Withdraw money\n3: Deposit money\n4: Display last 10 transactions\n5: Transfer funds\n6: Display transactions between a duration\n7: Check if account is inactive for a year\n8: Display last N transactions\n10: Exit\n:");
				choice = scanner.nextInt();
				switch (choice) {
				case 1: {
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					try {
						System.out.println("Current balance: " + bank.bankServiceImpl.showBalance(accountNo));
					} catch (InvalidAccountException e) {
						System.out.println(e);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					break;
				}
				case 2: {
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					System.out.print("Enter amount: ");
					double amount = scanner.nextDouble();
					if (amount < 0) {
						System.out.println("Negative amount not allowed");
						break;
					}
					try {
						System.out.println("Updated balance: " + bank.bankServiceImpl.withdraw(accountNo, amount));
					} catch (InvalidAccountException e) {
						System.out.println(e);
					} catch (InsufficientFundException e) {
						System.out.println(e);
					} catch (NegativeAmountException e) {
						System.out.println(e);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					break;
				}
				case 3: {
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					System.out.print("Enter amount: ");
					double amount = scanner.nextDouble();
					try {
						System.out.println("Updated balance: " + bank.bankServiceImpl.deposit(accountNo, amount));
					} catch (InvalidAccountException e) {
						System.out.println(e);
					} catch (NegativeAmountException e) {
						System.out.println(e);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					break;
				}
				case 4: {
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					try {
						System.out.println("Transactions-");
						System.out.println(bank.bankServiceImpl.display(accountNo));
					} catch (InvalidAccountException e) {
						System.out.println(e);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					break;
				}
				case 5: {
					System.out.print("Enter your account No: ");
					int senderAcc = scanner.nextInt();
					System.out.print("Enter receiver account No: ");
					int receiverAcc = scanner.nextInt();
					System.out.print("Enter amount: ");
					double amount = scanner.nextDouble();
					try {
						System.out.println(bank.bankServiceImpl.fundTransfer(senderAcc, receiverAcc, amount));
					} catch (NegativeAmountException e) {
						System.out.println(e);
					} catch (InvalidAccountException e) {
						System.out.println(e);
					} catch (InsufficientFundException e) {
						System.out.println(e);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					break;
				}
				case 6: {
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					System.out.print("Enter start date(dd/MM/yy): ");
					String str = scanner.next();
					Date startDate = null, endDate = null;
					try {
						startDate = new SimpleDateFormat("dd/MM/yy").parse(str);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					System.out.print("Enter end date(dd/MM/yy): ");
					str = scanner.next();
					try {
						endDate = new SimpleDateFormat("dd/MM/yy").parse(str);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					try {
						System.out.println("Transactions-");
						System.out.println(
								bank.bankServiceImpl.displayTransactionWithinDate(accountNo, startDate, endDate));
					} catch (InvalidAccountException e) {
						System.out.println(e);
					} catch (InvalidDateException e) {
						System.out.println(e);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					break;
				}
				case 7: {
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					try {
						if (bank.bankServiceImpl.isInactive(accountNo)) {
							System.out.println("Account Inactive");
						} else {
							System.out.println("Account active");
						}
					} catch (InvalidAccountException e) {
						System.out.println(e);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					break;
				}
				case 8: {
					System.out.print("Enter account No: ");
					int accountNo = scanner.nextInt();
					System.out.print("Enter value of n: ");
					int n = scanner.nextInt();
					try {
						System.out.println("Transactions-");
						String transactions = bank.bankServiceImpl.lastNTransactions(accountNo, n);
						System.out.println(transactions);
					} catch (InvalidAccountException e) {
						System.out.println(e);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					break;
				}
				case 9: {

					break;
				}
				case 10: {
					choice = 0;
					break;
				}
				default: {
					System.out.println("Invalid choice");
				}
				}
			} while (choice != 0);
		} finally {
			try {
				scanner.close();
				if (bank.bankServiceImpl instanceof BankServiceInt) {
					BankServiceImpl bsi = (BankServiceImpl) bank.bankServiceImpl;
					bsi.closeConnection();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
