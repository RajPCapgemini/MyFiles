package com.company.util;

import com.company.bean.Employee;

public class EmployeeUtil {
	private Employee employees[];
	public Employee[] getEmployees() {
		return employees;
	}
	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}
	public EmployeeUtil() {
		employees = new Employee[3];
		employees[0]=new Employee(101,"RP1",750000);
		employees[1]=new Employee(102,"RP2",800000);
		employees[2]=new Employee(103,"RP3",850000);
	}
}
