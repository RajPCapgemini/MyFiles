package com.cg.account.pojos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int transactionId;
	
	private LocalDateTime transactionDate;
	
	private String transactionType;
	
	private double transactionAmount;
	
	private double transactionBalance;
	
	@ManyToOne
	@JsonIgnore
	private Account account;
}
