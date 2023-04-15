package com.cg.bankapp.query;

import lombok.Data;

@Data
public class GetAccountByIdQuery {

	private int accountNo;
	
	public GetAccountByIdQuery(int accountNo) {
		super();
		this.accountNo=accountNo;
	}
}
