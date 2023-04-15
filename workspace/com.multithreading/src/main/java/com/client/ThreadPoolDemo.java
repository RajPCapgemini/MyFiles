package com.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThreadPool extends Thread{
	public void run() {
		System.out.println(Thread.currentThread().getName()+" "+"Child Thread...");
	}
}

public class ThreadPoolDemo {

	public static void main(String[] args) {
		MyThreadPool th1 = new MyThreadPool();
		MyThreadPool th2 = new MyThreadPool();
		MyThreadPool th3 = new MyThreadPool();
		MyThreadPool th4 = new MyThreadPool();
		MyThreadPool th5 = new MyThreadPool();
		
		th1.setName("th1");
		th2.setName("th2");
		th3.setName("th3");
		th4.setName("th4");
		th5.setName("th5");
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for(int i=0;i<10;i++) {
			executor.execute(th1);
			executor.execute(th2);
			executor.execute(th3);
			executor.execute(th4);
			executor.execute(th5);
		}
		

	}

}
