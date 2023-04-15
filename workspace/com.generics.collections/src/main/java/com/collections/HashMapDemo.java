package com.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class Book{
	String bookName;
	String authorName;
	double price;
	public Book(String bookName, String authorName,double price) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.price=price;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", authorName=" + authorName + ", price=" + price + "]";
	}
	
	
	
}

public class HashMapDemo {

	public static void main(String[] args) {
//		HashMap<Integer,String> mp = new HashMap<Integer,String>();
//		mp.put(1, "ONE");
//		mp.put(2, "TWO");
//		mp.put(3, "THREE");
//		mp.put(4, "FOUR");
//		mp.put(5, "FIVE");
//		Iterator itr=mp.entrySet().iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
//		for(Entry<Integer,String> m:mp.entrySet()) {
//			System.out.println(m.getKey()+" "+m.getValue());
//		}
//		for(String s:mp.values()) {
//			System.out.println(s);
//		}
		HashMap<Integer,Book> mp = new HashMap<Integer,Book>();
		mp.put(1005, new Book("Julius Ceaser","Shakepear",999));
		mp.put(1002, new Book("Half Girlfriend","Chetan Bhagat",450));
		mp.put(1003,null);
//		Iterator<Integer,Book> itr=mp.entrySet().iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		for(Entry<Integer,Book> m:mp.entrySet()) {
//			if(m.getValue().price>=800 && m.getValue().price<=1000)
			System.out.println(m.getKey()+ " "+ m.getValue());
		}
	}

}
