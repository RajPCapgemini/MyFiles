package com.cg.onlineshop;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.pojos.Product;
import com.cg.onlineshop.services.ProductService;

@SpringBootApplication
public class OnlineShopSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OnlineShopSpringApplication.class, args);
		ProductService service = context.getBean(ProductService.class,"productService");
		Scanner sc = new Scanner(System.in);
		
		boolean loop=true;
		do {
			System.out.print("Enter option: ");
			int option = sc.nextInt();
			switch(option) {
			case 1:{
				Product prod1=new Product(299,4,"Clean & Clear","Facewash");
				service.acceptProductDetails(prod1);
				break;
			}case 2:{
				System.out.print("Enter product ID: ");
				int pid=sc.nextInt();
				service.removeProdcutDetails(pid);
				break;
			}case 3:{
				try {
					service.getProductDetails(0);
				} catch (ProductDetailsNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}case 4:{
				List<Product> list = service.getAllProductDetails();
				for(Product p:list) {
					System.out.println(p);
				}
				break;
			}case 10:{
				loop=false;
				break;
			}
			}
		}while(loop);
	}

}
