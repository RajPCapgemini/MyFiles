package com.client;

class Ping extends Thread{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("Ping==>");
		}
	}
}
class Pong extends Thread{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("Pong====>");
		}
	}
}
public class PingPongDemo {

	public static void main(String[] args) {
		Ping p1 = new Ping();
		Pong p2 = new Pong();
		p1.start();
		p2.start();
		p2.start();
		for(int i=1;i<=10;i++) {
			System.out.println("Main==========>");
		}

	}

}
