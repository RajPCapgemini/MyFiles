package com.newschool.bean;

import java.util.Arrays;

public class ReportCard {
	private int marks[];
	private String result;
	
	public ReportCard() {
		
	}

	public ReportCard(int[] marks, String result) {
		super();
		this.marks = marks;
		this.result = result;
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
		return "ReportCard [marks=" + Arrays.toString(marks) + ", result=" + result + "]";
	}
}
