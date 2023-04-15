package com.newschool.dao;

import com.newschool.bean.Student;
import com.newschool.exception.InvalidStudentRollNoException;
import com.newschool.util.StudentReportCardUtil;

public class NewSchoolDaoImpl implements NewSchoolDao{
	private StudentReportCardUtil studentReportCardUtil;
	public NewSchoolDaoImpl() {
		studentReportCardUtil=new StudentReportCardUtil();
	}
	@Override
	public Student getByRollNo(int rollNo) throws InvalidStudentRollNoException{
		// TODO Auto-generated method stub
		Student students[]=studentReportCardUtil.getStudents();
		for(int i=0;i<students.length;i++) {
			if(students[i].getRollNo()==rollNo) {
				return students[i];
			}
		}
		throw new InvalidStudentRollNoException("Invalid Roll No");
	}

}
