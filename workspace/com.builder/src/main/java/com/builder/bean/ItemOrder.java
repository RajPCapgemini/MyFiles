package com.builder.bean;

//bean approach
//mutable
public class ItemOrder {
	private String book;
	private String clothes;
	private String food;
	private String flowers;
	public ItemOrder() {
		super();
	}
	public ItemOrder(String book, String clothes, String food, String flowers) {
		super();
		this.book = book;
		this.clothes = clothes;
		this.food = food;
		this.flowers = flowers;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getClothes() {
		return clothes;
	}
	public void setClothes(String clothes) {
		this.clothes = clothes;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getFlowers() {
		return flowers;
	}
	public void setFlowers(String flowers) {
		this.flowers = flowers;
	}
	@Override
	public String toString() {
		return "ItemOrder [book=" + book + ", clothes=" + clothes + ", food=" + food + ", flowers=" + flowers + "]";
	}
	
	
}
