package com.many2one;

import java.util.*;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "s_add_m2o")
public class AddressM2O {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int add_id;
	String addressLine1;
	String city;
	String state;
	int pincode;
	
	@ManyToOne
	@JoinColumn(name="rno")
	StudentAdd rno;

	public AddressM2O() {
		super();
	}

	public AddressM2O(int add_id, String addressLine1, String city, String state, int pincode) {
		super();
		this.add_id = add_id;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public int getAdd_id() {
		return add_id;
	}

	public void setAdd_id(int add_id) {
		this.add_id = add_id;
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
		return "Address [add_id=" + add_id + ", addressLine1=" + addressLine1 + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode;
	}
	
	
}
