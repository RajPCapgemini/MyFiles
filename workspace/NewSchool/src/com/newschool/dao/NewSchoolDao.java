package com.newschool.dao;

import com.newschool.bean.Student;
import com.newschool.exception.InvalidStudentRollNoException;

public interface NewSchoolDao {
	Student getByRollNo(int rollNo) throws InvalidStudentRollNoException;
}
