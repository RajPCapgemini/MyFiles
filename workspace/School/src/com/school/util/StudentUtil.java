package com.school.util;
import com.school.bean.Student;

public class StudentUtil {
	private Student students[];

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}
	public StudentUtil() {
		students = new Student[3];
		int [] marks1= {30,25,35,40,50};
		students[0]=new Student(101,"RP",marks1,"Pass");
		int [] marks2= {39,44,35,40,49};
		students[1]=new Student(102,"RP2",marks2,"Fail");
		int [] marks3= {35,44,35,47,50};
		students[2]=new Student(103,"RP3",marks3,"Pass");
	}
}
