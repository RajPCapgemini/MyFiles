package com.newschool.client;

import com.newschool.exception.InvalidStudentRollNoException;
import com.newschool.services.*;
import java.util.*;

public class Main {
	private NewSchoolService newSchoolServiceImpl;
	public Main() {
		newSchoolServiceImpl=new NewSchoolServiceImpl();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter 1 for Student Details\n2 for Student Report Card: ");
		int choice = scanner.nextInt();
		System.out.print("Enter Student Roll No: ");
		int rollNo=scanner.nextInt();
		do {
			switch(choice) {
				case 1:{
					try {
						System.out.println(main.newSchoolServiceImpl.showStudentDetails(rollNo));
					}catch(InvalidStudentRollNoException e) {
						System.out.println(e);
					}
					break;
				}
				case 2:{
					try {
						System.out.println(main.newSchoolServiceImpl.showStudentReportCard(rollNo));
					}catch(InvalidStudentRollNoException e) {
						System.out.println(e);
					}
					break;
				}
				default:
					System.out.println("Invalid choice");
			}
			System.out.print("Enter 0 to exit OR\nEnter choice: ");
			choice=scanner.nextInt();
			if(choice!=0) {
				System.out.print("Enter Roll No: ");
				rollNo=scanner.nextInt();
			}
		}while(choice!=0);
	}
		

}
