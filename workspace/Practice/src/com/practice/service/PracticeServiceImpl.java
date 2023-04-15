package com.practice.service;

import com.practice.bean.Employee;
import com.practice.dao.*;

public class PracticeServiceImpl implements PracticeService{
	private PracticeDao practiceDaoImpl;
	public PracticeServiceImpl() {
		practiceDaoImpl=new PracticeDaoImpl();
	}
	@Override
	public String getEmployeeName(int eId) {
		// TODO Auto-generated method stub
		Employee employee = practiceDaoImpl.getById(eId);
		return employee.getName();
	}

}
