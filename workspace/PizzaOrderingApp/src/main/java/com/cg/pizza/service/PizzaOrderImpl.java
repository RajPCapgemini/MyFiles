package com.cg.pizza.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.pizza.dao.*;
import com.cg.pizza.exceptions.*;
import com.cg.pizza.pojos.*;

@Component
public class PizzaOrderImpl implements PizzaOrder{

	@Autowired
	private PizzaDao pizzaDao;
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public Pizza createNewPizza(String pizzaName, String pizzaType, String pizzaSize, double pizzaPrice) {
		return pizzaDao.save(new Pizza(pizzaName,pizzaType,pizzaSize,pizzaPrice));
	}

	@Override
	public MyOrder newOrder(Customer customer, List<Pizza> pizzas) throws InvalidOrderException {
//		if(!checkOrder(pizzas)) throw new InvalidOrderException("Invalid Order");
		return orderDao.save(new MyOrder(customer,pizzas,399));
	}

	private double calculateOrderAmount(List<Pizza> pizzas) {
		double orderAmount=0;
		Iterator<Pizza> it = pizzas.iterator();
		while(it.hasNext())
			orderAmount+=it.next().getPizzaPrice();
		return orderAmount;
	}

	private boolean checkOrder(List<Pizza> pizzas) {
		Iterator<Pizza> it = pizzas.iterator();
		while(it.hasNext()) 
			if(!pizzaDao.existsById(it.next().getPizzaId())) return false;
		return true;
	}
}
