package com.company.dao;

import com.company.bean.Employee;
import com.company.exception.InvalidIdException;
import com.company.util.EmployeeUtil;

public class CompanyDaoImpl implements CompanyDao{
	private EmployeeUtil employeeUtil;
	public CompanyDaoImpl() {
		employeeUtil=new EmployeeUtil();
	}
	@Override
	public Employee getById(int eId) throws InvalidIdException{
		// TODO Auto-generated method stub
		Employee employees[] = employeeUtil.getEmployees();
		for(int i=0;i<employees.length;i++) {
			if(employees[i].geteId()==eId) {
				return employees[i];
			}
		}
		throw new InvalidIdException("Invalid Employee Id");
	}

	

}
