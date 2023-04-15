package com.cg.onlineshop.daos;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshop.pojos.Product;
public interface ProductDAO extends JpaRepository<Product, Integer>{
//	public Product save(Product product);
//	public Product update(Product product);
//	public boolean delete(int id);
//	public List<Product> getAllProducts();
//	public Optional<Product> getProduct(int id);
//	void insertBulkProducts(List<Product> products);
	List<Product> findByStarRatingLessThan(int starRating);
	List<Product> findByStarRatingBetween(int value1,int value2);
}