package com.collections;

import java.util.HashSet;
import java.util.Iterator;

public class SetDemo {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>(16,0.5f);
		set.add(12);
		set.add(10);
		set.add(944444344);
		set.add(1);
		System.out.println(set);
		Iterator<Integer> itr=set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().hashCode());
		}
	}

}
