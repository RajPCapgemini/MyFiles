package com.cg.pizza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pizza.exceptions.InvalidOrderException;
import com.cg.pizza.pojos.*;
import com.cg.pizza.service.PizzaOrder;

@RestController
public class OrderController {
	
	@Autowired
	private PizzaOrder service;
	
	@PostMapping(value={"/addPizza"},consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pizza> addPizza(@RequestBody Pizza pizza){
		return new ResponseEntity<Pizza>(service.createNewPizza(pizza.getPizzaName(), pizza.getPizzaType(), pizza.getPizzaSize(), pizza.getPizzaPrice()),HttpStatus.OK);
	}
	
	@PostMapping(value={"/createOrder"},consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MyOrder> createOrder(@RequestBody MyOrder order) throws InvalidOrderException{
		return new ResponseEntity<MyOrder>(service.newOrder(order.getCustomer(), order.getPizzas()),HttpStatus.OK);
	}
	
}
