package com.employee.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.employee.services.*;

public class Testing {
	EmployeeService employeeServiceImpl=new EmployeeServiceImpl();
	
	@Test
	public void testSalary() {
		try {
			double expected=750000;
			double actual = employeeServiceImpl.showSalary(101);
			assertEquals(expected,actual);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
