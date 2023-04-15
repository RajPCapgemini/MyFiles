package com.many2one;

import jakarta.persistence.EntityManager;
import java.util.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class RunnerM2O {
	public static void main(String [] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		AddressM2O adr1  = new AddressM2O();
		adr1.setAddressLine1("Hinjewadi");
		adr1.setCity("Pune");
		adr1.setState("Maharashtra");
		adr1.setPincode(20001);
		AddressM2O adr2 = new AddressM2O();
		adr2.setAddressLine1("Talwade");
		adr2.setCity("Pune");
		adr2.setState("Maharashtra");
		adr2.setPincode(20201);
		AddressM2O adr3 = new AddressM2O();
		adr3.setAddressLine1("Jayanagar");
		adr3.setCity("Bangalore");
		adr3.setState("Karnataka");
		adr3.setPincode(40201);
		StudentAdd s1 = new StudentAdd();
		s1.setName("Raj");
		s1.setMarks(98.9);
		s1.setResult("pass");
		s1.getAddress().add(adr1);
		s1.getAddress().add(adr2);
		StudentAdd s2 = new StudentAdd();
		s2.setName("Ravi");
		s2.setMarks(58.9);
		s2.setResult("fail");
		s2.getAddress().add(adr3);
		s2.getAddress().add(adr2);
		
		trans.begin();
		
		em.persist(adr1);
		em.persist(adr2);
		em.persist(adr3);
		
		em.persist(s1);
		em.persist(s2);
		
		
		trans.commit();
		
	}
}
