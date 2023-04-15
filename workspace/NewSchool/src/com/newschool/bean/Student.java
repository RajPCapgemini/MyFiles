package com.newschool.bean;

import java.util.Arrays;

public class Student {
	private int rollNo;
	private String name;
	private StudentAddress studentAddress;
	private ReportCard reportCardArray[];
	public Student() {
		
	}
	public Student(int rollNo, String name,ReportCard reportCardArray[], String city,String state,int pinCode) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.studentAddress = new StudentAddress(city,state,pinCode);
		this.reportCardArray = reportCardArray;
		
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", studentAddress=" + studentAddress
				+ ", reportCardArray=" + Arrays.toString(reportCardArray) + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StudentAddress getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(StudentAddress studentAddress) {
		this.studentAddress = studentAddress;
	}
	public ReportCard[] getReportCardArray() {
		return reportCardArray;
	}
	public void setReportCardArray(ReportCard[] reportCardArray) {
		this.reportCardArray = reportCardArray;
	}
	
}
