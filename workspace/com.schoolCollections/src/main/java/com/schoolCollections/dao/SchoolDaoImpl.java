package com.schoolCollections.dao;

import com.schoolCollections.bean.Student;
import com.schoolCollections.util.StudentUtil;
import java.util.*;

public class SchoolDaoImpl implements SchoolDao{
	private StudentUtil studentUtil;
	public SchoolDaoImpl() {
		studentUtil=new StudentUtil();
	}
	public Student getStudentByRollNo(int rollNo) {
		ArrayList<Student> students = studentUtil.getStudents();
		for(Student s:students) {
			if(s.getRollNo()==rollNo) {
				return s;
			}
		}
		return null;
	}

}
