package com.cg.bankapp.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionBetweenDatesDTO {

	private String startDateStr,endDateStr;
	private int accountNo;
}
