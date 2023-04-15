package com.prototype;

public class EmployeeRecord implements Prototype{

	int id;
	String name;
	double salary;
	
	
	public EmployeeRecord(int id, String name, double salary) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.salary=salary;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "EmployeeRecord [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}


	public Prototype getClone() {
		// TODO Auto-generated method stub
		return new EmployeeRecord(id,name,salary);
	}

}
