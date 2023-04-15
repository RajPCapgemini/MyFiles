package com.comparable.client;

import java.util.Arrays;
import com.comparable.bean.Employee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employees[]=new Employee[3];
		employees[0]=new Employee(102,"RP1");
		employees[1]=new Employee(106,"RP2");
		employees[2]=new Employee(101,"RP3");
//		for(int i=0;i<3;i++) {
//			System.out.println(employees[i]);
//		}
		Arrays.sort(employees);
		for(int i=0;i<3;i++) {
			System.out.println(employees[i]);
		}
	}

}
