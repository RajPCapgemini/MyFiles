package com.cg.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bank.pojos.*;

public interface AccountDao extends JpaRepository<Account, Integer>{
	
}
