package com.newschool.services;

import com.newschool.bean.ReportCard;
import com.newschool.bean.Student;
import com.newschool.dao.*;
import com.newschool.exception.InvalidStudentRollNoException;

public class NewSchoolServiceImpl implements NewSchoolService{
	private NewSchoolDao newSchoolDaoUtil;
	public NewSchoolServiceImpl() {
		newSchoolDaoUtil=new NewSchoolDaoImpl();
	}

	@Override
	public String showStudentDetails(int rollNo) throws InvalidStudentRollNoException {
		// TODO Auto-generated method stub
		Student student=newSchoolDaoUtil.getByRollNo(rollNo);
		return  student.getName(); // student.toString();
	}

	@Override
	public String showStudentReportCard(int rollNo) throws InvalidStudentRollNoException{
		// TODO Auto-generated method stub
		Student student = newSchoolDaoUtil.getByRollNo(rollNo);
		ReportCard reportCardArray[]=student.getReportCardArray();
		String returnValue="";
		for(int i=0;i<reportCardArray.length;i++) {
			returnValue+=reportCardArray[i].toString();
		}
		return returnValue;
	}
	
}
