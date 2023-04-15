package com.cg.pizza.pojos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class MyOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int orderId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Pizza> pizzas;
	
	private double orderAmount;

	public MyOrder() {
		super();
	}

	public MyOrder(Customer customer, List<Pizza> pizzas, double orderAmount) {
		super();
		this.customer = customer;
		this.pizzas = pizzas;
		this.orderAmount = orderAmount;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Override
	public String toString() {
		return "MyOrder [orderId=" + orderId + ", customer=" + customer + ", pizzas=" + pizzas + ", orderAmount="
				+ orderAmount + "]";
	}

	
	
	
}
