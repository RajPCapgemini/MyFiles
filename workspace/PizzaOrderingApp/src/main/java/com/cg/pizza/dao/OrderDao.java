package com.cg.pizza.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pizza.pojos.*;

public interface OrderDao extends JpaRepository<MyOrder, Integer>{

}
