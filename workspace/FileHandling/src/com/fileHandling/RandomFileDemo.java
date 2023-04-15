package com.fileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileDemo {

	public static void main(String[] args) throws IOException {
		File file = null;
		RandomAccessFile raf=null;
		try {
			file = new File("C:\\Users\\RAPRIYAD\\OneDrive - Capgemini\\Desktop\\IO Files\\input.txt");
			raf = new RandomAccessFile(file,"rw");
			System.out.println((char)raf.read());
			raf.seek(14);
			System.out.println((char)raf.read());
			raf.seek(20);
			System.out.println((char)raf.read());
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}

	}

}
