package com.employee.bean;

public class SalesPerson extends Employee{
	private int sales;
	private double commission;
	public SalesPerson() {
		
	}
	public SalesPerson(int eId,String eName,double eSalary,String eDesignation,int sales, double commission) {
		super(eId,eName,eSalary,eDesignation);
		this.sales = sales;
		this.commission = commission;
	}

	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
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
		return "SalesPerson [sales=" + sales + ", commission=" + commission + "]";
	}
	public SalesPerson display() {
		return this;
	}
	public double computeSalary() {
		return geteSalary()+sales*commission;
	}
}
