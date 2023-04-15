package com.schoolCollections.dao;

import com.schoolCollections.bean.Student;

public interface SchoolDao {
	public Student getStudentByRollNo(int rollNo);
}
