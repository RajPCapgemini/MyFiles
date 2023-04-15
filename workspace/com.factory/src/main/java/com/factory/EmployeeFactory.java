package com.factory;

import com.factory.EmployeeEnum.EmployeeType;

public class EmployeeFactory {

	public Employee getEmployee(EmployeeType manager){
		switch(manager) {
		case EmployeeEnum.EmployeeType.MANAGER: return new Manager(100,"Taj",8000,2000,1000);
		case EmployeeEnum.EmployeeType.SALESPERSON: return new SalesPerson(200,"Ravi",6000,2000,10);
		case EmployeeEnum.EmployeeType.CLERK: return new Clerk(300,"Ram",5000);
		default:return null;
		}
	}
}
