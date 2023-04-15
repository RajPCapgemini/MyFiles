package com.schoolCollections.service;

import com.schoolCollections.dao.*;
import com.schoolCollections.bean.*;
import java.util.*;

public class SchoolServiceImpl implements SchoolService{
	private SchoolDao schoolDaoImpl;
	public SchoolServiceImpl() {
		schoolDaoImpl=new SchoolDaoImpl();
	}
	public String showResult(int rollNo) {
		Student student = schoolDaoImpl.getStudentByRollNo(rollNo);
		
		ArrayList<ReportCard> reportCard =  student.getMarkSheet();
		boolean res=true;
		String ret="Pass";
		for(ReportCard rc:reportCard) {
			rc.setTotalMarks(rc.calculateTotalMarks());
			rc.getTotalMarks();
			if(rc.getTotalMarks()<50) {
				res=false;
				rc.setResult("Fail");
				ret="Fail";
			}
		}
		return ret;
	}

	public int showTotalMarks(int rollNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
