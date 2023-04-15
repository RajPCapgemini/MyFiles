package com.schoolCollections.bean;

import java.util.ArrayList;

public class ReportCard {
	private ArrayList<Integer> marks;
	private int totalMarks;
	private String result;
	public ReportCard() {
		
	}
	public ArrayList<Integer> getMarks() {
		return marks;
	}
	public void setMarks(ArrayList<Integer> marks) {
		this.marks = marks;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public ReportCard(ArrayList<Integer> marks) {
		super();
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "ReportCard [marks=" + marks + ", totalMarks=" + totalMarks + ", result=" + result + "]";
	}
	public int calculateTotalMarks() {
		int total=0;
		for(Integer i:marks) {
			total+=i;
		}
		return total;
	}
	
	
}
