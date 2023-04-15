package com.practice.dao;

import com.practice.bean.Employee;
import com.practice.util.EmployeeUtil;

public class PracticeDaoImpl implements PracticeDao{
	private EmployeeUtil employeeUtil;
	public PracticeDaoImpl() {
		employeeUtil=new EmployeeUtil();
	}
	@Override
	public Employee getById(int eId) {
		// TODO Auto-generated method stub
		Employee employees[]=employeeUtil.getEmployees();
		for(int i=0;i<employees.length;i++) {
			if(employees[i].geteId()==eId) {
				return employees[i];
			}
		}
		return null;
	}
	 
}
