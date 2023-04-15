package com.builder.ctor;

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
		this(book,clothes,food);
		this.flowers = flowers;
	}
	
	public ItemOrder(String book, String clothes, String food) {
		super();
		this.book = book;
		this.clothes = clothes;
		this.food = food;
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
