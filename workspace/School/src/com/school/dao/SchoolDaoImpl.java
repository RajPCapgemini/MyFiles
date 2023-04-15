package com.school.dao;

import com.school.bean.Student;
import com.school.util.StudentUtil;

public class SchoolDaoImpl implements SchoolDao{
	private StudentUtil studentUtil;
	public SchoolDaoImpl() {
		studentUtil=new StudentUtil();
	}
	@Override
	public Student getById(int rollNo) {
		Student studentArray[] = studentUtil.getStudents();
		for(int i=0;i<studentArray.length;i++) {
			if(studentArray[i].getRollNo()==rollNo) {
				return studentArray[i];
			}
		}
		return null;
	}

}
