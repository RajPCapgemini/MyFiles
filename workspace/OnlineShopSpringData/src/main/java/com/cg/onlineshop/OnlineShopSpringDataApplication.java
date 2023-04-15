package com.cg.onlineshop;

import java.util.List;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.pojos.Product;
import com.cg.onlineshop.services.ProductService;

@SpringBootApplication
public class OnlineShopSpringDataApplication {

	public static void main(String[] args) throws ProductDetailsNotFoundException {
		ApplicationContext context = SpringApplication.run(OnlineShopSpringDataApplication.class, args);
		ProductService service = context.getBean(ProductService.class,"productService");
		Scanner sc = new Scanner(System.in);
		
		boolean loop=true;
		do {
			System.out.print("Enter option: ");
			int option = sc.nextInt();
			switch(option) {
			case 1:{
				System.out.print("Enter price: ");
				int price=sc.nextInt();
				System.out.print("Enter rating: ");
				int rating = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter description: ");
				String description=sc.nextLine();
				System.out.print("Enter name: ");
				String name=sc.next();
				Product prod1=new Product(price,rating,description,name);
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
			}case 5:{
				System.out.print("Enter rating range: ");
				int a = sc.nextInt(),b=sc.nextInt();
				List<Product> list = service.getAllProductDetailsBetweenRating(a, b);
				for(Product p: list) System.out.println(p);
				break;
			}case 10:{
				loop=false;
				break;
			}
			}
		}while(loop);
		
	}

}
