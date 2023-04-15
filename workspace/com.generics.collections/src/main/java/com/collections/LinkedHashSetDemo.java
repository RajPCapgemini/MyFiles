package com.collections;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.add(1033);
		set.add(101);
		set.add(102);
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
