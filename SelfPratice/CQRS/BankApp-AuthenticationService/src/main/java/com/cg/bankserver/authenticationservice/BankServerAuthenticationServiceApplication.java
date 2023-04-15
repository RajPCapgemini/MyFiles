package com.cg.bankserver.authenticationservice;

import com.cg.bankserver.authenticationservice.entities.User;
import com.cg.bankserver.authenticationservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BankServerAuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServerAuthenticationServiceApplication.class, args);
	}

}
