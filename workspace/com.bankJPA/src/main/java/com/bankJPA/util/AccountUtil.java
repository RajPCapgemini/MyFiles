package com.bankJPA.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AccountUtil {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction trans = null;
	public AccountUtil() {
		emf = Persistence.createEntityManagerFactory("bank_jpa");
		em = emf.createEntityManager();
		trans = em.getTransaction();
	}
	public AccountUtil(EntityManagerFactory emf, EntityManager em, EntityTransaction trans) {
		super();
		this.emf = emf;
		this.em = em;
		this.trans = trans;
	}
	public EntityManagerFactory getEmf() {
		return emf;
	}
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	public EntityTransaction getTrans() {
		return trans;
	}
	public void setTrans(EntityTransaction trans) {
		this.trans = trans;
	}
	public void closeResources() {
		emf.close();
		em.close();
		System.out.println("Closed all resources.");
	}
}
