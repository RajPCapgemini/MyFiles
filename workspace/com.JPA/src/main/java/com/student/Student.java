package com.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity 	//marker annotation
@Table(name="students")
public class Student {
	@Id //persistence identity --PK in table
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(initialValue=10, name = "stud_seq",allocationSize=10)
	int rno;
	String name;
	double marks;
	String result;
	public Student() {
		super();
	}
	public Student(int rno, String name, double marks, String result) {
		super();
		this.rno = rno;
		this.name = name;
		this.marks = marks;
		this.result = result;
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
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", marks=" + marks + ", result=" + result + "]";
	}
	
	
}
