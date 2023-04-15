package com.cg.transaction.pojos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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
