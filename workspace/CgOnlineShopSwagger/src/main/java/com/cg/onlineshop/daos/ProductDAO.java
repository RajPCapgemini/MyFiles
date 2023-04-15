package com.cg.onlineshop.daos;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshop.pojos.Product;
public interface ProductDAO extends JpaRepository<Product, Integer>{
		
}