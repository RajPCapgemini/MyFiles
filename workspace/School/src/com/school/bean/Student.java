package com.school.bean;

import java.util.Arrays;

public class Student {
	private int rollNo;
	private String name;
	private int marks[];
	private String result;
	
	public Student() {
		
	}

	public Student(int rollNo, String name, int[] marks, String result) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
		this.result = result;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
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
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + Arrays.toString(marks) + ", result="
				+ result + "]";
	}
	
}
