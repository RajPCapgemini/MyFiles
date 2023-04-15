package com.newschool.util;

import com.newschool.bean.ReportCard;
import com.newschool.bean.Student;

public class StudentReportCardUtil {
	private Student students[];
	private ReportCard reportCardArray[];
	
	public StudentReportCardUtil() {
		students=new Student[3];
		reportCardArray=new ReportCard[2];
		int marks1[]= {10,20,30};
		int marks2[]= {25,15,35};
		reportCardArray[0]=new ReportCard(marks1,"Pass");
		reportCardArray[1]=new ReportCard(marks2,"Fail");
		students[0]=new Student(101,"RP1",reportCardArray,"Patna","Bihar",801105);
		
		int marks3[]= {10,20,30};
		int marks4[]= {25,15,35};
		reportCardArray[0]=new ReportCard(marks3,"Pass");
		reportCardArray[1]=new ReportCard(marks4,"Fail");
		students[1]=new Student(102,"RP2",reportCardArray,"Pune","Maharashtra",801105);
		
		int marks5[]= {10,20,30};
		int marks6[]= {25,15,35};
		reportCardArray[0]=new ReportCard(marks5,"Pass");
		reportCardArray[1]=new ReportCard(marks6,"Fail");
		students[2]=new Student(103,"RP3",reportCardArray,"Dehradun","Uttrakhand",248002);
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public ReportCard[] getReportCardArray() {
		return reportCardArray;
	}

	public void setReportCardArray(ReportCard[] reportCardArray) {
		this.reportCardArray = reportCardArray;
	}
}
