package com.cg.bankapp.command.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateEvent {

	private String uid;
	private int accountNo;
	private double balance;
	private int customerId;
}
