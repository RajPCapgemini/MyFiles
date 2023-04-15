package com.client;

import java.util.*;

class Service{
	private int tokenNo=0;
	private int serviceNo=0;
	
	
	public int getServiceNo() {
		return serviceNo;
	}
	public int getTokenNo() {
		return tokenNo;
	}
	public void setToken(int tokenNo) {
		this.tokenNo = tokenNo;
	}
	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}
	
}
class Window extends Thread{
	Service service;
	Window(Service service){
		this.service=service;
	}
	public void run() {
		service.setToken(service.getTokenNo()+1);
		System.out.println(Thread.currentThread().getName()+" "+ service.getTokenNo());
	}
}
public class CounterService {
	
	public static void main(String[] args) {
		Service service = new Service();
		Window cust1 = new Window(service);
		Window cust2 = new Window(service);
		cust1.setName("customer 1");
		cust2.setName("Customer 2");
		cust1.start();
		cust2.start();
//		System.out.println(service.getTokenNo()+" "+service.getServiceNo());
	}

}