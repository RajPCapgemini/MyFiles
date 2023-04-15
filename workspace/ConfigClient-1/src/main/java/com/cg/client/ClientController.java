package com.cg.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientController {
	@Value("${message:Some default message}")
	private String message;
	
	@RequestMapping("/message")
	public String getMessage() {
		System.out.println("Message==="+message);
		return message;
	}
}
