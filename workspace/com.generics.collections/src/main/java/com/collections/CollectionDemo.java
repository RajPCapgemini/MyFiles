package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(0, 30);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(400);
		list.addAll(0,list2);
		for(Integer i:list) {
			System.out.print(i+" ");
		}
		System.out.println();
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			Integer temp=it.next();
			System.out.println(temp);
			
		}
		
		System.out.println();
		list.forEach((x)->{System.out.print(x+" ");});
		
		System.out.println();
		list.forEach(System.out::print);
//		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
//		ArrayList<Integer> list2 = new ArrayList<Integer>();
//		list2.add(100);
//		list.add(list2);
//		for(ArrayList<Integer> arr: list) {
//			for(Integer i:arr) {
//				System.out.print(i);
//			}
//		}
	}

}
