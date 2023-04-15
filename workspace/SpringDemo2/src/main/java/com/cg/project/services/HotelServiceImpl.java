package com.cg.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelServiceImpl implements HotelService{
	@Autowired
	private KitchenService kitchenService;
	
	public void acceptOrder(List<String> foodItems) {
		String food = kitchenService.cookTheFood(foodItems);
		System.out.println(food);
	}

}
