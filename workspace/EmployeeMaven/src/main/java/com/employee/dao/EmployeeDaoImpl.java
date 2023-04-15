package com.employee.dao;

import com.employee.bean.Employee;
import com.employee.exception.InvalidEmployeeIdException;
import com.employee.util.EmployeeUtil;

public class EmployeeDaoImpl implements EmployeeDao{
	private EmployeeUtil employeeUtil;
	public EmployeeDaoImpl() {
		employeeUtil=new EmployeeUtil();
	}
	public Employee getEmployeeById(int eId) throws InvalidEmployeeIdException{
		Employee employee[]=employeeUtil.getEmployees();
		for(int i=0;i<employee.length;i++) {
			if(employee[i].geteId()==eId) {
				return employee[i];
			}
		}
		throw new InvalidEmployeeIdException("Employee with Id '"+eId+"' does not exits");
	}
	public Employee[] getEmployees() {
		Employee employees[]=employeeUtil.getEmployees();
		return employees;
	}
}
