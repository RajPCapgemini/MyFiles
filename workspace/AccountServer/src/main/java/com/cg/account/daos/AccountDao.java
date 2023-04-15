package com.cg.account.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.account.pojos.Account;

public interface AccountDao extends JpaRepository<Account, Integer>{

}
