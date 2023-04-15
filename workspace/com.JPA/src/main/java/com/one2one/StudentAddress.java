package com.one2one;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "student_address")
public class StudentAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int rno;
	String name;
	
	@ElementCollection
	List<Address> address;

	public StudentAddress() {
		super();
	}

	public StudentAddress(int rno, String name, List<Address> address) {
		super();
		this.rno = rno;
		this.name = name;
		this.address = address;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentAddress [rno=" + rno + ", name=" + name + ", address=" + address + "]";
	}
	public static void main(String [] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		Address adr1 = new Address("Jayanagar","Bangalore","Karnataka",400001);
		Address adr2 = new Address("Talwade","Pune","Maharashtra",420001);
		
		StudentAddress s1 = new StudentAddress();
		s1.setName("raj");
		s1.setAddress(new ArrayList<Address>());
		s1.getAddress().add(adr1);
		s1.getAddress().add(adr2);
		
		trans.begin();
		
		em.persist(s1);
		
		trans.commit();
	}
	
	
}
