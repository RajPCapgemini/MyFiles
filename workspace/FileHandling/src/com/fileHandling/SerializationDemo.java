package com.fileHandling;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable{
	int rno;
	String name;
	double marks;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public Student(int rno, String name, double marks) {
		super();
		this.rno = rno;
		this.name = name;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", marks=" + marks + "]";
	}
	
}

public class SerializationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Student s1 = new Student(100,"Raj",98.9);
		Student s2 = new Student(200,"Ravi",88.9);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\RAPRIYAD\\OneDrive - Capgemini\\Desktop\\IO Files\\serializationOutput.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(s1);
		oos.writeObject(s2);
		
		oos.close();
//		fos.close();
		
		//=========================
		FileInputStream fis =new FileInputStream("C:\\Users\\RAPRIYAD\\OneDrive - Capgemini\\Desktop\\IO Files\\serializationOutput.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		fos = new FileOutputStream("C:\\Users\\RAPRIYAD\\OneDrive - Capgemini\\Desktop\\IO Files\\ReadableserializationOutput.txt");
		StringBuffer str=new StringBuffer("");
		Student ss =(Student)ois.readObject();
		str.append(ss.toString());
		try {
			while(true) {
				System.out.println(ss);
				ss = (Student)ois.readObject();
				str.append(ss.toString());
			}
			
		}catch(Exception e) {
			fos.write(str.toString().getBytes());
		}
		finally {
			ois.close();
			fis.close();
		}

	}

}
