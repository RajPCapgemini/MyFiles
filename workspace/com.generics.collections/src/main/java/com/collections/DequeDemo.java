package com.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DequeDemo {

	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<>();
//		dq.addFirst(101);
		dq.add(102);
//		dq.addLast(103);
//		dq.addFirst(104);
//		System.out.println(dq);
//		dq.addLast(10);
//		System.out.println(dq);
//		System.out.println(dq.poll());
//		dq.remove(1000);
//		System.out.println(dq);
		
		System.out.println(dq.remove(1000));
	}

}
