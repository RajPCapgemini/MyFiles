package com.client;

import java.util.*;
import java.util.stream.Stream;

class Student{
	private int rollNo;
	private String name;
	private double avg;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public Student(int rollNo, String name, double avg) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", avg=" + avg + "]";
	}
	
}
public class StudentLambda {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(38,"Raj",68));
		students.add(new Student(20,"RK",30));
		students.add(new Student(40,"RS",39));
		
		//using forEach loop
//		students.forEach((Student it)->{
//			if(it.getAvg()>=30) {
//				System.out.println(it);
//			}
//		});
		//before sorting
//		students.forEach(System.out::println);
//		
//		//using comparator to sort
//		Collections.sort(students,(s1,s2)->{
//			if(s1.getAvg()>=s2.getAvg()) return 1;
//			else return -1;
//		});
//		//after sorting
//		students.forEach(s->System.out.println(s));

		Stream<Student> filtered = students.stream().filter(s->s.getAvg()>60);
		filtered.forEach(s->System.out.println(s));
	}

}
