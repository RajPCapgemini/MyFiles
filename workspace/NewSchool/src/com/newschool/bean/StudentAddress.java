package com.newschool.bean;

public class StudentAddress {
	private String city;
	private String state; 
	private int pinCode;
	public StudentAddress() {
		
	}
	public StudentAddress(String city, String state, int pinCode) {
		super();
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}
	@Override
	public String toString() {
		return "StudentAddress [city=" + city + ", state=" + state + ", pinCode=" + pinCode + "]";
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
}
