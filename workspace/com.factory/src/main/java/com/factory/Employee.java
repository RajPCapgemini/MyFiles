package com.factory;

public abstract class Employee {
	private int eId;
	private String name;
	private double basic;
	
	public Employee() {
		super();
	}

	public Employee(int eId, String name, double basic) {
		super();
		this.eId = eId;
		this.name = name;
		this.basic = basic;
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

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", name=" + name + ", basic=" + basic + "]";
	}

	abstract double getVariableSalary();
	
	public double computeSalary() {
		return basic+this.getVariableSalary();
	}
}
