package com.cg.bankapp.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

	private String transactionType;
	private LocalDateTime transactionDate;
	private double transactionAmount;
	private int accountNo;
}
