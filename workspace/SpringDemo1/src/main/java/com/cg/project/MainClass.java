package com.cg.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.project.services.GreetingService;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("projectBeans.xml");
		
		GreetingService service = context.getBean(GreetingService.class, "greetingService");
		service.greet("Raj");
	}

}