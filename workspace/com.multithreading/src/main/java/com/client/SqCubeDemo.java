package com.client;

class Square extends Thread{
	int side;
	public Square(int side) {
		this.side=side;
	}
	public void run() {
		for(int i=1;i<=10;i++)
		System.out.println("Sqaure of "+i+": "+i*i);
	}
}

class Cube extends Thread{
	int side;
	public Cube(int side) {
		this.side=side;
	}
	public void run() {
		for(int i=1;i<=10;i++)
		System.out.println("Cube of "+i+": "+i*i*i);
	}
}

public class SqCubeDemo {

	public static void main(String[] args) {
		Square sq1=new Square(3);
		Cube c1 =new Cube(3);
		c1.start();
		sq1.start();
		try {
			System.out.println("sq1: "+sq1.getState());
			Square.yield();
			System.out.println("sq1: "+sq1.getState());
			
//			System.out.println(Thread.currentThread().getState());
			c1.join();
//			System.out.println(Thread.currentThread().getState());
//			System.out.println(c1.getState());
		}catch(InterruptedException e) {
			System.out.println(e);
		}
		for(int i=1;i<=10;i++)
			System.out.println("MainCube of "+i+": "+i*i*i);

	}

}
