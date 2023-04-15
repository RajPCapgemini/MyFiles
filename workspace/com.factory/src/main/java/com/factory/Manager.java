package com.factory;

public class Manager extends Employee{
	double foodAllowance;
	double travelAllowance;
	
	public Manager() {
		super();
	}

	public Manager(int eId, String name, double basic, double foodAllowance, double travelAllowance) {
		super(eId, name, basic);
		this.foodAllowance = foodAllowance;
		this.travelAllowance = travelAllowance;
	}

	@Override
	public String toString() {
		return "Manager [foodAllowance=" + foodAllowance + ", travelAllowance=" + travelAllowance + "]";
	}

	public double getFoodAllowance() {
		return foodAllowance;
	}

	public void setFoodAllowance(double foodAllowance) {
		this.foodAllowance = foodAllowance;
	}

	public double getTravelAllowance() {
		return travelAllowance;
	}

	public void setTravelAllowance(double travelAllowance) {
		this.travelAllowance = travelAllowance;
	}

	@Override
	double getVariableSalary() {
		return foodAllowance+travelAllowance;
	}
	
}
