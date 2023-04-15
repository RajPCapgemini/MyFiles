package com.cg.account.pojos;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int accountNo;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Customer customer;
	
	private double balance;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Transaction> transactions;
}
