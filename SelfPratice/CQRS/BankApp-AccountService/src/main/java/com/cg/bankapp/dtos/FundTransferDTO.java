package com.cg.bankapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FundTransferDTO {

	private int fromAccountNo;
	private int toAccountNo;
	private double amount;
}
