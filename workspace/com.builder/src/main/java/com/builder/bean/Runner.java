package com.builder.bean;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemOrder order = new ItemOrder("Horror","Traditional","Sweets","Rose");
		System.out.println(order.getBook());
		System.out.println(order.getClothes());
		System.out.println(order.getFood());
		System.out.println(order.getFlowers());
	}

}
