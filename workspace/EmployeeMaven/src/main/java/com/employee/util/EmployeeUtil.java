package com.employee.util;

import com.employee.bean.*;

public class EmployeeUtil {
	private Employee employees[];
	
	public Employee[] getEmployees() {
		return employees;
	}
	public void setEmployee(Employee[] employees) {
		this.employees = employees;
	}
	public EmployeeUtil() {
		employees=new Employee[5];
		employees[0]=new Employee(101,"Raj",750000,"Employee");
		employees[1]=new SalesPerson(102,"Aman",600000,"SalesPerson",15,5);
		employees[2]=new Manager(103,"Rajat",700000,"Manager",100000);
		employees[3]=new Manager(104,"Raju",650000,"Manager",50000);
		employees[4]=new SalesPerson(105,"Raja",550000,"SalesPerson",13,2);
	}
}
