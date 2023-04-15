package com.fileHandling;

import java.io.File;

public class FIleDemo {
	public static void main(String [] args) {
//		File file = new File("a.txt");//current Path
		File file = new File("Documents\\a.text");
		System.out.println("File: "+file.isFile());
		System.out.println("Hidden: "+file.isHidden());
		System.out.println("Write: "+file.canWrite());
		System.out.println("Absolute path: "+file.isAbsolute());
		System.out.println("Read: "+file.canRead());
		System.out.println("Length: "+file.length());
	
	}
}
