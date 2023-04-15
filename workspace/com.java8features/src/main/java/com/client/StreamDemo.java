package com.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr = new ArrayList<Integer>(List.of(12,100,34,45,56));
//		Stream<Integer> myStream = arr.stream();
//		myStrream.forEach(n-> sysout)
		int st = arr.stream().max(Integer::compare).get();
//		st.ifPresent(System.out::println);
		System.out.println(st);
		
	}

}
