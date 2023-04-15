package com.builder.builder;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemOrder.Build build = new ItemOrder.Build();
		build.book("Fairy Tales").clothes("Formal").food("Snacks").flowers("Marigold");
		ItemOrder order = new ItemOrder(build);
		System.out.println(order.getBook());
		System.out.println(order.getClothes());
		System.out.println(order.getFood());
		System.out.println(order.getFlowers());
	}

}
