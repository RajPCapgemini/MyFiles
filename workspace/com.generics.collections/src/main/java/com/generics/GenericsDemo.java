package com.generics;

public class GenericsDemo {

	public static void main(String[] args) {
//		Object obj= new String("hello");
//		obj=10;
//		String str= obj.toString();
//		System.out.println(str);
		
		Object obj[]=new Object[3];
		obj[0]="Hello";
		obj[1]="hi";
		obj[2]=100;
		
		for(int i=0;i<3;i++) {
			String str = (String) obj[i];
			System.out.println(str);
		}
	}

}
