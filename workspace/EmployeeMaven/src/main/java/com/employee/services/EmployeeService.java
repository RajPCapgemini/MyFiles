package com.employee.services;

import com.employee.exception.InvalidEmployeeIdException;

public interface EmployeeService {
	public void display(int eId)throws InvalidEmployeeIdException;
	public double showSalary(int eId) throws InvalidEmployeeIdException;
	public void getBonus(int eId) throws InvalidEmployeeIdException;
	public void showEmployees();
}
