package com.cg.bankapp.query.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Account_Query")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {

	@Id
	private int accountNo;
	
	@Column(unique=true)
	private String uid;
	
	private double balance;
	private int customerId;
}
