package com.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

//ORM object relational management tool
public class PersistenceStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
//		Student s  =  new Student();
//		s.setRno(2);
//		s.setName("Ravi");
//		s.setMarks(88.9);
//		s.setResult("Pass");
		
		Student s  =  new Student();
//		s.setRno(1);
		s.setName("Raj");
		s.setMarks(98.9);
		s.setResult("Pass");
		
		Student s1  =  new Student();
//		s.setRno(2);
		s1.setName("Raju");
		s1.setMarks(68.9);
		s1.setResult("Pass");
		
		trans.begin();
		
		em.persist(s); // insert
		em.persist(s1);
//		Student newSt=em.find(Student.class, 4);//fetch record
//		System.out.println(newSt);//if record not found null is returned
		
//		Student newSt=em.find(Student.class, 2);
//		em.remove(newSt);// find and remove
		
//		Student newSt=em.find(Student.class, 2);
//		newSt.setName("Ravindra");
		
		trans.commit();
		
		em.close();
		emf.close();
	}

}
