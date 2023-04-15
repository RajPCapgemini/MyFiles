package com.fileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.SequenceInputStream;

public class FileOutput {
	public static void main(String [] args) throws IOException {
//		File file = new File("C:\\Users\\RAPRIYAD\\OneDrive - Capgemini\\Desktop\\IO Files\\input.txt");
//		File file2 = new File("C:\\Users\\RAPRIYAD\\OneDrive - Capgemini\\Desktop\\IO Files\\output.txt");
//		FileOutputStream fos = null;
//		try {
//			fos=new FileOutputStream(file);
//			fos.write("Hello".getBytes());
//		}finally {
//			
//		}
//		FileInputStream fis=null;
//		StringBuffer s=new StringBuffer("");
//		FileOutputStream fos2=null;
//		try {
//			fis=new FileInputStream(file);
//			int c;
//			while((c=fis.read())!=-1) {
//				s.append((char)c);
//			}
//			fos2=new FileOutputStream(file2);
//			fos2.write(s.toString().getBytes());
//			
//		}catch(FileNotFoundException e) {
//			System.out.println(e);
//		}finally {
//			fos.close();
//			fis.close();
//			fos2.close();
//		}
		
//		OutputStream os =null;// OutputStream is super class
//		byte barray[]= {65,66,67,68,69,70};//A B C D E F
//		
//		try {
//			os = new FileOutputStream("C:\\Users\\RAPRIYAD\\OneDrive - Capgemini\\Desktop\\IO Files\\input.txt");
//			os.write(barray);
//		}catch(FileNotFoundException e) {
//			System.out.println(e);
//		}
//		finally {
//			if(os!=null) {
//				os.close();
//			}
//			
//		}
		FileInputStream fisFirst=null,fisSecond=null;
		SequenceInputStream sis=null;
		FileOutputStream fos=null;
		try {
		fisFirst = new FileInputStream("C:\\Users\\RAPRIYAD\\OneDrive - Capgemini\\Desktop\\IO Files\\input.txt");
		fisSecond = new FileInputStream("C:\\Users\\RAPRIYAD\\OneDrive - Capgemini\\Desktop\\IO Files\\input1.txt");
		
		sis = new SequenceInputStream(fisFirst,fisSecond);
		
		fos=new FileOutputStream("C:\\Users\\RAPRIYAD\\OneDrive - Capgemini\\Desktop\\IO Files\\output.txt");
		
		int c;
		while((c=sis.read())!=-1) {
			fos.write((char)c);
		}
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		finally {
			fisFirst.close();
			fisSecond.close();
			sis.close();
			fos.close();
		}
		
	}
}
