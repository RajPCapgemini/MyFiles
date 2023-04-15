package com.toy.bean;

public class SoftToy extends Toy{
	private double weight;
	public SoftToy() {
		
	}
	public SoftToy(int toyNo,double toyPrice,String toyBrand,double weight) {
		super(toyNo,toyPrice,toyBrand);
		this.weight=weight;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
