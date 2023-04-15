package com.client;

class Mythread1 extends Thread{
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

public class PriorityDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread.currentThread().setPriority(9);
		Mythread1 th1 = new Mythread1();
		th1.setName("mythread");
		th1.start();
		System.out.println("main "+Thread.currentThread().getPriority());
		System.out.println("th1 Priority: "+th1.getPriority());
		
		System.out.println("Min: "+Thread.MIN_PRIORITY);
		System.out.println("Norm: "+Thread.NORM_PRIORITY);
		System.out.println("Max: "+Thread.MAX_PRIORITY);
		
	}

}
