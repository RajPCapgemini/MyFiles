package com.schoolCollections.util;

import java.util.ArrayList;
import java.util.Arrays;

import com.schoolCollections.bean.*;

public class StudentUtil {
	private ArrayList<Student> students;
	public StudentUtil() {
		students = new ArrayList<Student>();
		ArrayList<Integer> marks = new ArrayList<Integer>(Arrays.asList(50,60,70,80,85));
		ArrayList<Integer> marks2 = new ArrayList<Integer>(Arrays.asList(55,65,75,85,80));
		ArrayList<ReportCard> report = new ArrayList<ReportCard>();
		report.add(new ReportCard(marks));
		report.add(new ReportCard(marks2));
		students.add(new Student(101,"RP",report));
		marks = new ArrayList<Integer>(Arrays.asList(55,65,75,85,80));
		report = new ArrayList<ReportCard>();
		report.add(new ReportCard(marks));
		students.add(new Student(102,"RP",report));
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
}
