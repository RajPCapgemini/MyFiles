package com.schoolCollections.client;

import com.schoolCollections.service.*;

public class SchoolDemo {
	private SchoolService schoolServiceImpl;
	SchoolDemo(){
		schoolServiceImpl = new SchoolServiceImpl();
	}
	public static void main(String[] args) {
		SchoolDemo obj = new SchoolDemo();
		System.out.println(obj.schoolServiceImpl.showResult(101));;
	}

}
