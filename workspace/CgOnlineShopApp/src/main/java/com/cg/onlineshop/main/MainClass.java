package com.cg.onlineshop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.pojos.*;
import com.cg.onlineshop.services.*;

public class MainClass {

	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("onlineShopBeans.xml");
			ProductService productService = context.getBean(ProductService.class, "productService");

			Product prod1 = new Product(499, 4, "Good", "Shampoo");

			System.out.println(productService.acceptProductDetails(prod1));

			productService.getProductDetails(3232);
		} catch (ProductDetailsNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}