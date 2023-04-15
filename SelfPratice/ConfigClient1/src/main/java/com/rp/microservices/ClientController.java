package com.rp.microservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	@Value("${greeting}")
	private String greeting;
	
	@RequestMapping("/greeting")
	public String sayGreeting() {
		return greeting;
	}
}
