package com.collections;

import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;

//class MyComparator implements Comparator{
//
//	@Override
//	public int compare(Object o2) {
//		Employee e2=(Employee)o2;
//		if(this.>e2.salary) return 1;
//		else if(this.salary<e2.salary) return -1;
//		else return 0;
//	}
//	
//}

public class TreeSetDemo {

	public static void main(String[] args) {
//		Set<Integer> set = new TreeSet<Integer>();
//		set.add(10);
//		set.add(60);
//		set.add(5);
//		Iterator<Integer> itr=set.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		Set<Employee> set = new TreeSet<Employee>();
		set.add(new Employee(101,"RP",15000));
		set.add(new Employee(102,"RK",14000));
		set.add(new Employee(101,"RJ",15000));
		Iterator<Employee> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
