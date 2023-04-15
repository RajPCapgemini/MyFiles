package com.newschool.services;

import com.newschool.bean.Student;
import com.newschool.exception.InvalidStudentRollNoException;

public interface NewSchoolService {
	String showStudentDetails(int rollNo) throws InvalidStudentRollNoException;
	String showStudentReportCard(int rollNo) throws InvalidStudentRollNoException;
	
}
