package com.cg.project.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.project.services.HotelService;
import com.cg.project.services.KitchenService;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("projectBeans.xml");
		
		HotelService hotelService = context.getBean(HotelService.class,"hotelService");
		
		
		System.out.print("Enter number of food items: ");
		int n = sc.nextInt();
		List<String> foodItems=new ArrayList<String>();
		while(n>0) {
			String item=sc.nextLine();
			foodItems.add(item);
			n--;
		}
		hotelService.acceptOrder(foodItems);
		
	}

}
