package com.cg.bankapp.query;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetTransactionByAccountNoQuery {

	private String uid;
	private int transactionId;
	private String transactionType;
	private LocalDateTime transactionDate;
	private double transactionAmount;
	private int accountNo;
	
	public GetTransactionByAccountNoQuery(int accountNo) {
		super();
		this.accountNo=accountNo;
	}
}
