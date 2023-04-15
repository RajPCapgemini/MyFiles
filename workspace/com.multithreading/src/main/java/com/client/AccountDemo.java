package com.client;

class Account{
	int accId;
	String name;
	double balance;
	
	public Account() {
		
	}
	synchronized public void deposit(double amount) {
//		double temp;
//		temp = this.balance;
//		try {
//			Thread.sleep(2000);
//		}catch(InterruptedException e) {
//			System.out.println(e);
//		}
//		temp += amount;
//		this.balance = temp;
		System.out.println("In acc dep "+Thread.currentThread().getName());
		this.balance+=amount;
		notify();
	}
	synchronized public void withdraw(double amount) {
		System.out.println("In account withdraw "+Thread.currentThread().getName());
		if(balance-amount<0) {
			try {
				System.out.println(Thread.currentThread().getName());
				System.out.println("before wait: "+balance);
				wait();
				System.out.println("after wait: "+balance);
			}catch(InterruptedException e) {
				
			}
		}
		this.balance-=amount;
	}
	public Account(int accId, String name, double balance) {
		super();
		this.accId = accId;
		this.name = name;
		this.balance = balance;
	}
	
}

class Father extends Thread{
	Account account;
	public Father(Account account) {
		this.account=account;
	}
	public void run() {
		
		System.out.println("In Father: "+Thread.currentThread().getName());
//		account.withdraw(6000);
//		account.deposit(2000);
		System.out.println("After father : "+account.balance);
	}
}
class Mother extends Thread{
	Account account;
	public Mother(Account account) {
		this.account=account;
	}
	public void run() {
		System.out.println("In Mother "+Thread.currentThread().getName());
		account.withdraw(6000);
		account.deposit(4000);
		System.out.println("After mother : "+account.balance);
	}
}
public class AccountDemo {

	public static void main(String[] args) {
		Account acc1 = new Account(100,"RP",5000);
		Father father = new Father(acc1);
		Mother mother = new Mother(acc1);
		mother.setName("mother thread ");
		father.setName("Father thread ");
		mother.setPriority(2);
		father.setPriority(1);
		mother.start();
		father.start();
		
//		System.out.println(acc1.balance);

	}

}
