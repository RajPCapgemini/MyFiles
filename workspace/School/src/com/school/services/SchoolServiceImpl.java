package com.school.services;
import com.school.bean.Student;
import com.school.dao.SchoolDao;
import com.school.dao.SchoolDaoImpl;

public class SchoolServiceImpl implements SchoolService{
	
	private SchoolDao schoolDaoImpl;
	
	public SchoolServiceImpl() {
		schoolDaoImpl = new SchoolDaoImpl();
	}
	
	@Override
	public String showResult(int rollNo) {
		Student student = schoolDaoImpl.getById(rollNo);
		String result = student.getResult();
		return result;
	}

	@Override
	public String showName(int rollNo) {
		// TODO Auto-generated method stub
		Student student = schoolDaoImpl.getById(rollNo);
		String name=student.getName();
		return name;
		
	}
	
}
