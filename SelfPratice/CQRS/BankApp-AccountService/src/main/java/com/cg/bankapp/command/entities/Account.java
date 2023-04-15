package com.cg.bankapp.command.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Account_Command")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int accountNo;
	private double balance;
	private int customerId;
}
