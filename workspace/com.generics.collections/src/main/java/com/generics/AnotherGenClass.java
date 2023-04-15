package com.generics;

public class AnotherGenClass <T>{
	private T data[]=(T[])new Object[50];
	private int idx=0;
	public void append(T d) {
		data[idx]=d;
		idx++;
	}
	public void display() {
		for(int i=0;i<idx;i++) {
			System.out.print(data[i]+" ");
		}
	}
	public static void main(String[] args) {
		AnotherGenClass<Integer> genArray = new AnotherGenClass<Integer>();
		genArray.append(100);
		genArray.append(100);
		genArray.append(100);
		genArray.append(100);
		genArray.display();
	}

}
