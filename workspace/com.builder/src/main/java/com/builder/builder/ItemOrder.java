package com.builder.builder;

//builder approach
//immutable
public class ItemOrder {
	private String book;
	private String clothes;
	private String food;
	private String flowers;
	
	public ItemOrder(Build build) {
		this.book=build.book;
		this.clothes=build.clothes;
		this.food=build.food;
		this.flowers= build.flowers;
	}
	
	public static class Build{
		private String book;
		private String clothes;
		private String food;
		private String flowers;
		
		//instantiating outer class using build class object and return the object
		ItemOrder getItemOrder(Build build) {
			return new ItemOrder(this);
		}
		public Build() {
			new ItemOrder(this);
		}
		public Build book(String book){
			this.book=book;
			return this;
		}
		public Build clothes(String clothes) {
			this.clothes=clothes;
			return this;
		}
		public Build food(String food) {
			this.food=food;
			return this;
		}
		public Build flowers(String flowers) {
			this.flowers=flowers;
			return this;
		}
	}

	public String getBook() {
		return book;
	}

	public String getClothes() {
		return clothes;
	}

	public String getFood() {
		return food;
	}

	public String getFlowers() {
		return flowers;
	}
	
	
}
