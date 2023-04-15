package com.app.vehicles;

public class Vehicle {
	private int registrationNo;
	private String color;
	private double price;
	public Vehicle() {
		
	}
	public Vehicle(int registrationNo, String color, double price) {
		super();
		this.registrationNo = registrationNo;
		this.color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle [registrationNo=" + registrationNo + ", color=" + color + ", price=" + price + "]";
	}
	public boolean equals(Vehicle vehicle) {
		if(registrationNo==vehicle.registrationNo) return true;
		else return false;
	}
	
}
