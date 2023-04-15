package com.school.client;

import com.school.services.*;

public class Main {
	private SchoolService schoolService;
	public Main(){
		schoolService = new SchoolServiceImpl();
	}
	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.schoolService.showName(103));
	}
}
