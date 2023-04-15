package com.practice.util;

import com.practice.bean.*;

public class EmployeeUtil {
	private Employee employees[];
	public Employee[] getEmployees() {
		return employees;
	}
	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}
	public EmployeeUtil() {
		employees=new Employee[3];
		employees[0]=new Employee(101,"RP");
		employees[1]=new Employee(102,"RP");
	}
}
