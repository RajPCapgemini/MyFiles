package com.one2one;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Embeddable
public class Address {
	String addressLine1;
	String city;
	String state;
	int pincode;
	public Address() {
		super();
	}
	public Address(String addressLine1, String city, String state, int pincode) {
		super();
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
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
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ "]";
	}
	
}
