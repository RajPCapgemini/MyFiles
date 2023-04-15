package com.cg.project.services;

import java.util.List;

public class KitchenServiceImpl implements KitchenService{

	public String cookTheFood(List<String> foodItems) {
		if(foodItems.size()==0) return "No orders";
		String food = foodItems.get(foodItems.size()-1);
		return "Cooked: "+food;
	}

}
