package com.app.vehicles;

public class Vehicle2{
	private int registrationNo;
	private String color;
	private double price;
	
	public Vehicle2(int registrationNo, String color, double price) {
		super();
		this.registrationNo = registrationNo;
		this.color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle2 [registrationNo=" + registrationNo + ", color=" + color + ", price=" + price + "]";
	}
	public boolean equals(Vehicle2 v) {
		
//		System.out.println(this.registrationNo+"-"+v.registrationNo+"/"+this.color+"-"+v.color);
		if(this.registrationNo==v.registrationNo && this.color.equals(v.color)) return true;
		else return false;
	}
}
