package com.toy.bean;

public class ElectronicToy extends Toy{
	private int numberOfCells;

	public int getNumberOfCells() {
		return numberOfCells;
	}

	public void setNumberOfCells(int numberOfCells) {
		this.numberOfCells = numberOfCells;
	}

	public ElectronicToy(int toyNo,double toyPrice,String toyBrand,int numberOfCells) {
		super(toyNo,toyPrice,toyBrand);
		this.numberOfCells = numberOfCells;
	}
	
}
