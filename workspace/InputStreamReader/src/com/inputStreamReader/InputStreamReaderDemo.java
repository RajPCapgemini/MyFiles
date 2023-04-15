package com.inputStreamReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader cin= null;
		try {
			cin = new InputStreamReader(System.in);
			char c;
			System.out.println("Enter character:   'q' to quit");
			c = (char)cin.read();
			while(c!='q') {
				System.out.print(c);
				c=(char)cin.read();
			}
		}finally {
			if(cin!=null) {
				cin.close();
			}
		}

	}

}
