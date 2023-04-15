package com.one2one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		Address adr1 = new Address("Jayanagar","Bangalore","Karnataka",400001);
		
		StudentA s1 = new StudentA();
		s1.setName("kavya");
		s1.setMarks(65);
		s1.setResult("Pass");
		s1.setAddress(adr1);
		
		trans.begin();
		
		em.persist(s1);
		
		trans.commit();
		

	}

}
