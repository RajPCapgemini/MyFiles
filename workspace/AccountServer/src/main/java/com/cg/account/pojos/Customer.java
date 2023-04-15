package com.cg.account.pojos;

import jakarta.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerId;
	
	private String firstName;
	private String lastName;
}
