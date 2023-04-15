package com.generics;

public class GenClass <T>{
	private T data;
	private static int idx=0;
	public GenClass(T data, int idx) {
		super();
		this.data = data;
		this.idx = idx;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data=data;
	}
	public void append(GenClass genObj) {
		
	}
	public static void main(String[] args) {
//		GenClass genClass = new GenClass();
//		genClass.setData(100);
		

	}

}
