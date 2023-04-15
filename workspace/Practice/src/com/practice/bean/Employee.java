package com.practice.bean;

public class Employee implements Comparable{
	private int eId;
	private String name;
	
	public Employee() {
		
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(int eId, String name) {
		super();
		this.eId = eId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Employee) {
			Employee e =(Employee)o;
			if(this.eId>e.eId) 
				return -1;
			else
				return 1;
		}
		return 0;
	}
	
}
