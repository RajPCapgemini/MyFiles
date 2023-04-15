package com.company.services;

import com.company.exception.InvalidIdException;

public interface CompanyService {
	String getEmployeeName(int eId) throws InvalidIdException;
	double getEmployeeSalary(int eId) throws InvalidIdException;
}
