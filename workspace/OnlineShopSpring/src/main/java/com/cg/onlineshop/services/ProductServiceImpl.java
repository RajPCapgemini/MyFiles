package com.cg.onlineshop.services;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineshop.daos.ProductDAO;
import com.cg.onlineshop.daos.ProductDAOImpl;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.pojos.Product;

@Component(value = "productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDao;
	
	@Override
	public Product acceptProductDetails(Product product) {
		// TODO Auto-generated method stub
		 productDao.save(product);
		 return product;
	}

	@Override
	public List<Product> getAllProductDetails() {
		// TODO Auto-generated method stub
		List<Product> list = productDao.getAllProducts();
		return list;
	}

	@Override
	public Product getProductDetails(int id) throws ProductDetailsNotFoundException {
		// TODO Auto-generated method stub
		Optional<Product> optional = productDao.getProduct(id);
//		Supplier<ProductDetailsNotFoundException> supplier = ()->new ProductDetailsNotFoundException("Product Not Found");
		return optional.orElseThrow(()->new ProductDetailsNotFoundException("Product Not Found"));
	}

	@Override
	public void acceptBulkProductsDetails(List<Product> products) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeProdcutDetails(int id) {
		// TODO Auto-generated method stub
		productDao.delete(id);
		return false;
	}
	
	
}
