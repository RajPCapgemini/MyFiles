package com.cg.onlineshop.services;
import java.util.List;

import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.pojos.Product;
public interface ProductService {
	public Product acceptProductDetails(Product product);
	public List<Product> getAllProductDetails();
	public Product getProductDetails(int id)throws ProductDetailsNotFoundException;
	public void acceptBulkProductsDetails(List<Product> products);
	public boolean removeProdcutDetails(int id);
}