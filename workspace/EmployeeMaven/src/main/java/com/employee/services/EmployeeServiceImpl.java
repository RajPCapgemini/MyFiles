package com.employee.services;

import com.employee.dao.*;
import com.employee.exception.*;
import com.employee.bean.*;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDaoImpl;
	public EmployeeServiceImpl() {
		employeeDaoImpl=new EmployeeDaoImpl();
	}
	public void display(int eId) throws InvalidEmployeeIdException{
		Employee employee = employeeDaoImpl.getEmployeeById(eId);
		System.out.println(employee.display());
	}

	public double showSalary(int eId) throws InvalidEmployeeIdException{
		Employee employee = employeeDaoImpl.getEmployeeById(eId);
		System.out.println(employee.computeSalary());
		return employee.computeSalary();
	}
	public void getBonus(int eId) throws InvalidEmployeeIdException{
		Employee employee = employeeDaoImpl.getEmployeeById(eId);
		if(employee instanceof Manager) {
			Manager manager = (Manager)employee;
			System.out.println(manager.getBonus());
		}
	}
	public void showEmployees(){
		Employee employees[]=employeeDaoImpl.getEmployees();
		for(int i=0;i<employees.length;i++) {
			System.out.println(employees[i]);
		}
		
	}
}
