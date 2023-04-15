package com.company.dao;

import com.company.bean.Employee;
import com.company.exception.InvalidIdException;

public interface CompanyDao {
	Employee getById(int eId) throws InvalidIdException;
}
