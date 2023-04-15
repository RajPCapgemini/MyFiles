package com.company.services;

import com.company.bean.Employee;
import com.company.dao.CompanyDao;
import com.company.dao.CompanyDaoImpl;
import com.company.exception.InvalidIdException;

public class CompanyServiceImpl implements CompanyService{
	private CompanyDao companyDaoImpl;
	public CompanyServiceImpl() {
		companyDaoImpl=new CompanyDaoImpl();
	}
	@Override
	public String getEmployeeName(int eId) throws InvalidIdException{
		// TODO Auto-generated method stub
		Employee employee = companyDaoImpl.getById(eId);
		return employee.geteName();
	}

	@Override
	public double getEmployeeSalary(int eId) throws InvalidIdException{
		// TODO Auto-generated method stub
		Employee employee = companyDaoImpl.getById(eId);
		return employee.geteSalary();
	}

}
