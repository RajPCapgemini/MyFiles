package com.client;

class DaemonThreadClass extends  Thread{

	public void run() {
		// TODO Auto-generated method stub
		if(Thread.currentThread().isDaemon())
			System.out.println("Daemon Thread");
		else
			System.out.println("not Daomon Thread");
	}
	
}

public class DaemonThreadDemo {

	public static void main(String[] args) {
		DaemonThreadClass th1 = new DaemonThreadClass();
		DaemonThreadClass th2 = new DaemonThreadClass();
		DaemonThreadClass th3 = new DaemonThreadClass();
		DaemonThreadClass th4 = new DaemonThreadClass();
		th2.setDaemon(true);
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}

}
