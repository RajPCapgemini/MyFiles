package com.junit.test;

public class Calci {
	int a;
	int b;
	public Calci(int a,int b) {
		super();
		this.a = a;
		this.b = b;
	}
	public int add() {
		return this.a+this.b;
	}
	public int sub() {
		return this.a-this.b;
	}
	public int multiply() {
		return this.a*this.b;
	}
	public int divide() {
		return this.a/this.b;
	}
}
