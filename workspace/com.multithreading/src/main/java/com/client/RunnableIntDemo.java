package com.client;

class MyRunner implements Runnable{

	public void run() {
		System.out.println(Thread.currentThread().getName()+" Child Thread....");
		
	}
	
}

public class RunnableIntDemo {

	public static void main(String[] args) {
		MyRunner runner = new MyRunner();
		Thread th1 = new Thread(runner,"First");
		Thread th2 = new Thread(runner,"Second");
		th1.start();
		th2.start();
		Thread th3 = new Thread(runner,"Third");
		th3.start();
		Thread th4 = new Thread(runner,"Fourth");
		th4.start();
		System.out.println(th1.getName());

	}

}
