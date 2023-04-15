package com.cg.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bank.pojos.*;

public interface BankDao extends JpaRepository<Account, Integer>{
	
}
