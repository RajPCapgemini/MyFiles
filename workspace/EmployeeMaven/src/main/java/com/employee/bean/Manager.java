package com.employee.bean;

public class Manager extends Employee{
	private double bonus;
	public Manager() {
		
	}
	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Manager [bonus=" + bonus + "]";
	}

	public Manager(int eId,String eName,double eSalary,String eDesignation,double bonus) {
		super(eId,eName,eSalary,eDesignation);
		this.bonus = bonus;
	}
	public Manager display() {
		return this;
	}
	public double computeSalary() {
		return geteSalary()+bonus;
	}
}
