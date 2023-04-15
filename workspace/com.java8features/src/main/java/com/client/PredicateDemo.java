package com.client;

import java.util.function.*;
import java.util.*;

public class PredicateDemo {
	public static void display(List<Integer> st,Predicate<Integer> condi) {
//		for(Integer s:st) {
//			if(condi.test(s)) {
//				System.out.println(s);
//			}
//		}
		st.forEach((s)->{if(condi.test(s)) System.out.println(s);});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> st = new ArrayList<Integer>(List.of(80,99,10,60,55));
		Predicate<Integer> pr=a->(a>60);
		display(st,pr);
	}

}
