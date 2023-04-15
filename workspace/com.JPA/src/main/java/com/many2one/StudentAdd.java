package com.many2one;

import java.util.*;

import com.one2one.Address;

import jakarta.persistence.*;

@Entity
@Table(name = "studentM2O")
public class StudentAdd {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int rno;
	String name;
	double marks;
	String result;
	
	@OneToMany(targetEntity = AddressM2O.class,mappedBy = "rno")
	List<AddressM2O> address = new ArrayList<AddressM2O>();

	public StudentAdd() {
		super();
	}

	public StudentAdd(int rno, String name, double marks, String result, List<AddressM2O> address) {
		super();
		this.rno = rno;
		this.name = name;
		this.marks = marks;
		this.result = result;
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

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public List<AddressM2O> getAddress() {
		return address;
	}

	public void setAddress(List<AddressM2O> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentAdd [rno=" + rno + ", name=" + name + ", marks=" + marks + ", result=" + result + ", address="
				+ address + "]";
	}
	
	
}
