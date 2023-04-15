package com.cg.project.beans;

import java.util.List;
import java.util.Map;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private List<Integer> marks;
	
	private Map<String,Address> address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Integer> getMarks() {
		return marks;
	}
	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}
	public Map<String, Address> getAddress() {
		return address;
	}
	public void setAddress(Map<String, Address> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", marks=" + marks
				+ ", address=" + address + "]";
	}
	
	
	
}
