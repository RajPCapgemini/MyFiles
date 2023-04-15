package com.cg.pizza.service;

import java.util.List;

import com.cg.pizza.exceptions.InvalidOrderException;
import com.cg.pizza.pojos.*;

public interface PizzaOrder {
	public Pizza createNewPizza(String pizzaName,String pizzaType,String pizzaSize,double pizzaPrice);
	public MyOrder newOrder(Customer customer,List<Pizza> pizzas) throws InvalidOrderException ;
}
