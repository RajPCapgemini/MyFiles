package com.collections;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		TreeMap<Integer,Book> mp = new TreeMap<Integer,Book>();
		mp.put(102, new Book("Shiva Triology","Amish",999));
		mp.put(101, new Book("Gulliver's Travel","Ryan Reynolds",1400));
		mp.put(105, null);
		for(Entry<Integer,Book> m:mp.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
			m.getValue().price+=100;
		}
//		mp.get(102).price=800;
		for(Entry<Integer,Book> m:mp.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}
	}

}
