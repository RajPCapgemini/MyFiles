package com.practice.client;

import java.time.LocalDate;
import java.util.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Stream;

import com.practice.bean.Employee;
import com.practice.service.*;

//class R1 extends Thread{
//	public void run() {
//		System.out.println(Thread.currentThread().getName());
//	}
//}
//class R2 extends Thread{
//	public void run() {
//		new Thread(new R1(),"R1a").start();
//		new Thread(new R1(),"R1b").start();
//		System.out.println(Thread.currentThread().getName());
//	}
//}
public class Main {
//	private PracticeService practiceServiceImpl;
//	public Main() {
//		practiceServiceImpl = new PracticeServiceImpl();
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Main main = new Main();
//		Employee employees[]=new Employee[3];
//		employees[0]=new Employee(102,"RP1");
//		employees[1]=new Employee(106,"RP2");
//		employees[2]=new Employee(101,"RP3");
////		for(int i=0;i<3;i++) {
////			System.out.println(employees[i]);
////		}
//		Arrays.sort(employees);
//		for(int i=0;i<3;i++) {
//			System.out.println(employees[i]);
//		}
//		List<String> list = new ArrayList<String>();
//		list.add("2");
//		list.add("r");
//		list.add("yy");
//		list.add("uu");
//		
//		Iterator it = list.iterator();
//		Collections.reverse(list);
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//		new Thread(new R2(),"R2").start();
		
		List<String> list = new ArrayList<String>();
		list.add("b");
		list.add("c");
		list.add("a");
//		System.out.println(list.indexOf("c"));
//		System.out.println(list.indexOf("d"));
//		Collections.reverse(list);
//		System.out.println(list.indexOf("a"));
//		list.
		
//		Map<String,Integer> mp = new HashMap<String,Integer>();
//		mp.put(null, null);
//		mp.put(null, 43);
//		mp.put("THREE", null);
//		
//		System.out.println(mp);
		
//		Stream st = list.stream();
//		st.forEach(s->System.out.println(s));
//		st.forEach(s->System.out.println(s));
		Thread t = new Thread("t1");
		t.start();
		
//		float d = 25.346777f;
//		System.out.print(d);
	}

}
