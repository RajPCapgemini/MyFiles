package com.schoolCollections.bean;

import java.util.*;

public class Student {
	private int rollNo;
	private String name;
	private ArrayList<ReportCard> markSheet;
	public Student() {
		
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
	public ArrayList<ReportCard> getMarkSheet() {
		return markSheet;
	}
	public void setMarkSheet(ArrayList<ReportCard> markSheet) {
		this.markSheet = markSheet;
	}
	public Student(int rollNo, String name, ArrayList<ReportCard> markSheet) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.markSheet = markSheet;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", markSheet=" + markSheet + "]";
	}
	
	
}
