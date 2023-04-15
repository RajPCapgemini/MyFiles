package com.factory;

public class SalesPerson extends Employee{
	private double sales;
	private double commission;
	

	public SalesPerson() {
		super();
	}
	

	public SalesPerson(int eId, String name, double basic, double sales, double commission) {
		super(eId, name, basic);
		this.sales = sales;
		this.commission = commission;
	}
	

	public double getSales() {
		return sales;
	}


	public void setSales(double sales) {
		this.sales = sales;
	}


	public double getCommission() {
		return commission;
	}


	public void setCommission(double commission) {
		this.commission = commission;
	}


	


	@Override
	public String toString() {
		return "SalesPerson [sales=" + sales + ", commission=" + commission + ", geteId()=" + geteId() + ", getName()="
				+ getName() + ", getBasic()=" + getBasic() + ", toString()=" + super.toString() + ", computeSalary()="
				+ computeSalary() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


	@Override
	double getVariableSalary() {
		// TODO Auto-generated method stub
		return sales*commission;
	}

}
