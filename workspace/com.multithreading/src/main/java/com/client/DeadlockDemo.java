package com.client;

public class DeadlockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		try {
			System.out.println("Going to stop");
			Thread.currentThread().interrupt();
			System.out.println(Thread.currentThread().isInterrupted());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Never going to execute");
	}

}
