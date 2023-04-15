package com.cg.project.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.project.beans.Student;

public class MainClass {
	public static void main(String [] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("projectBeans.xml");
		
		Student student = (Student)context.getBean(Student.class,"student");
		System.out.println(student);
	}
}
