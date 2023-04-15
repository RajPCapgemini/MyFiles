package com.employee.dao;

import com.employee.bean.Employee;
import com.employee.exception.*;
import com.employee.util.EmployeeUtil;

public interface EmployeeDao {
	public Employee getEmployeeById(int eId) throws InvalidEmployeeIdException;
	public Employee[] getEmployees();
}
