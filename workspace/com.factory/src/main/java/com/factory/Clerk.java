package com.factory;

public class Clerk extends Employee{

	public Clerk(int eId,String name,double basic) {
		super(eId,name,basic);
	}
	@Override
	double getVariableSalary() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		return "Clerk [getVariableSalary()=" + getVariableSalary() + ", geteId()=" + geteId() + ", getName()="
				+ getName() + ", getBasic()=" + getBasic() + ", toString()=" + super.toString() + ", computeSalary()="
				+ computeSalary() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
