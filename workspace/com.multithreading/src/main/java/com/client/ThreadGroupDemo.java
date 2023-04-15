package com.client;

class MyThreadGroup implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("--"+Thread.currentThread().getName());
	}
	
}

public class ThreadGroupDemo {

	public static void main(String[] args) {
		MyThreadGroup runnable = new MyThreadGroup();
		ThreadGroup tg1 = new ThreadGroup("Language Group");
		
		Thread t1 = new Thread(tg1,runnable,"CPP");
		t1.start();
		Thread t2 = new Thread(tg1,runnable,"Python");
		t2.start();
		Thread t3 = new Thread(tg1,runnable,"Java");
		t3.start();
		
		tg1.list();

	}

}
