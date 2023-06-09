package com.cg.onlineshop.pojos;

import jakarta.persistence.*;

@Entity
public class Product { 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int price;
	private int starRating;
	private String description ;
	private String name;
	
	public Product() {
		super();
	}

	public Product(int price, int starRating, String description, String name) {
		super();
		this.price = price;
		this.starRating = starRating;
		this.description = description;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStarRating() {
		return starRating;
	}
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", starRating=" + starRating + ", description=" + description
				+ ", name=" + name + "]";
	}
	
	
}