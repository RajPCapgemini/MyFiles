package com.toy.bean;

public class Toy implements Sell{
	private int toyNo;
	private double toyPrice;
	private String toyBrand;
	public Toy(){
		
	}
	public Toy(int toyNo, double toyPrice, String toyBrand) {
		super();
		this.toyNo = toyNo;
		this.toyPrice = toyPrice;
		this.toyBrand = toyBrand;
	}
	public int getToyNo() {
		return toyNo;
	}
	public void setToyNo(int toyNo) {
		this.toyNo = toyNo;
	}
	public double getToyPrice() {
		return toyPrice;
	}
	public void setToyPrice(double toyPrice) {
		this.toyPrice = toyPrice;
	}
	public String getToyBrand() {
		return toyBrand;
	}
	public void setToyBrand(String toyBrand) {
		this.toyBrand = toyBrand;
	}
	@Override
	public String toString() {
		return "Toy [toyNo=" + toyNo + ", toyPrice=" + toyPrice + ", toyBrand=" + toyBrand + "]";
	}
	@Override
	public double sellWithoutDiscount() {
		// TODO Auto-generated method stub
		return toyPrice;
	}
	@Override
	public double sellWithDiscount() {
		// TODO Auto-generated method stub
		double off=(toyPrice*(discount/100));
		return toyPrice-off;
	}
	
}
