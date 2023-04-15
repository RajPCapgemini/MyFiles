package com.practice.client;

import java.util.Scanner;

public class CheckTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int side1=sc.nextInt(),side2=sc.nextInt(),side3=sc.nextInt();
		if(side1+side2>side3 && side2+side3>side1 && side1+side3>side2) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}

	}

}
