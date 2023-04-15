package com.client;

class MyThread extends Thread{
	//Never overload run Method
	//Never Override start method
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Child Thread...");
		System.out.println(Thread.currentThread().getState()+" Child Thread...");
	}
	
}
public class MultithreadingDemo{

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getState());
		
		MyThread th1=new MyThread();
		th1.start();
		th1.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getState());
		MyThread th2 = new MyThread();
		th2.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getState());
		MyThread th3 = new MyThread();
		th3.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getState());
		MyThread th4 = new MyThread();
		th4.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getState());

	}

}
