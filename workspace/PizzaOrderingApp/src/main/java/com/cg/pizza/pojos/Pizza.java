package com.cg.pizza.pojos;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Embeddable
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int pizzaId;
	private String pizzaName;
	private String pizzaType;
	private String pizzaSize;
	private double pizzaPrice;
	public Pizza() {
		super();
	}
	
	public Pizza(int pizzaId, String pizzaName, String pizzaType, String pizzaSize, double pizzaPrice) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaName = pizzaName;
		this.pizzaType = pizzaType;
		this.pizzaSize = pizzaSize;
		this.pizzaPrice = pizzaPrice;
	}

	public Pizza(String pizzaName, String pizzaType, String pizzaSize, double pizzaPrice) {
		super();
		this.pizzaName = pizzaName;
		this.pizzaType = pizzaType;
		this.pizzaSize = pizzaSize;
		this.pizzaPrice = pizzaPrice;
	}
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public String getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public double getPizzaPrice() {
		return pizzaPrice;
	}
	public void setPizzaPrice(double pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}
	@Override
	public String toString() {
		return "Pizza [pizzaId=" + pizzaId + ", pizzaName=" + pizzaName + ", pizzaType=" + pizzaType + ", pizzaSize="
				+ pizzaSize + ", pizzaPrice=" + pizzaPrice + "]";
	}
	
	
}
