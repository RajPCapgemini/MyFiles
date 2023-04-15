package com.cg.pizza.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pizza.pojos.*;

public interface PizzaDao extends JpaRepository<Pizza, Integer>{
	public Pizza findByPizzaNameAndPizzaTypeAndPizzaSize(String pizzaName,String pizzaType,String pizzaSize);
}
