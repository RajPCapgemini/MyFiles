package com.client;

class Service{
	private int tokenNo=0;
	private int serviceNo=0;
	public Service() {
		
	}
	public int getTokenNo() {
		return tokenNo;
	}
	public void setTokenNo(int tokenNo) {
		this.tokenNo = tokenNo;
	}
	public int getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}
	public void giveToken() {
		this.tokenNo++;
		String tName = Thread.currentThread().getName();
		System.out.println(tName+" issued token. wait for your order");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		serviceCompleted();
	}
	public void serviceCompleted() {
		this.serviceNo++;
		System.out.println("ServiceNo completed "+serviceNo);
		notify();
	}
	
}
class Window extends Thread{
	Service service;
	public Window(Service service,String name) {
		super(name);
		this.service=service;
	}
	public void run() {
		String tName = Thread.currentThread().getName();
		synchronized(service) {
			try {
				System.out.println("token given from "+tName);
				service.giveToken();
				service.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Service completed for :"+tName);
	}
}
public class CounterService {

	public static void main(String[] args) {
		Service service = new Service();
		Thread window1 = new Window(service,"window1");
		Thread window2 = new Window(service,"window2");
		window1.start();
		window2.start();
//		System.out.println(window1.getName());
		
	}

}
