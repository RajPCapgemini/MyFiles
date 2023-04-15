package com.cg.onlineshop.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineshop.pojos.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Component(value="productDao")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private EntityManagerFactory factory;
	
	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
		return product;
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Product toDelete = em.find(Product.class, id);
		System.out.println(toDelete);
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		EntityManager em = factory.createEntityManager();
		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p",Product.class);
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public Optional<Product> getProduct(int id) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Product product =  em.find(Product.class,id);
		em.getTransaction().commit();
		em.close();
		Optional<Product> optional = Optional.ofNullable(product);
		return optional;
	}

	@Override
	public void insertBulkProducts(List<Product> products) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}