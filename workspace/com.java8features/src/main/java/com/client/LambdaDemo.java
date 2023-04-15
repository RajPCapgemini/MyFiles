package com.client;

import java.util.*;

//@FunctionalInterface
//interface Lambda2{
//	public void show();
//}
// functional interface cannot inherit another functional interface
@FunctionalInterface
interface Lambda1{
	public void display();
}

//class MyClass implements Lambda1{
//	public void display() {
//		System.out.println("Display");
//	}
//}

interface Lambda2{
	public void display(String name);
}

interface AddLambda{
	public void add(int a,int b);
}

interface AddLambda1{
	public int add(int a,int b);
}

interface Factorial{
	public int fact(int n);
}
public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Lambda1 l1 = new Lambda1() {
//			
//			@Override
//			public void display() {
//				// TODO Auto-generated method stub
//				System.out.println("Anonymous class");
//			}
//		};
//		Lambda1 l2 = ()->{System.out.println("lambda expression diplay method"); };
//		l1.display();
//		l2.display();
		
//		

//		AddLambda lb = (int a,int b)->{System.out.println(a+b);};
//		lb.add(5, 5);
		
//		AddLambda1 lb = (int a,int b)->{return a+b;};
//		System.out.println(lb.add(2, 3));
//		Factorial f = (int n)->{
//			int res=1;
//			while(n>0) {
//				res*=n;
//				n--;
//			}
//			return res;
//		};
//		System.out.println(f.fact(4));
		
//		List<String> myStr = new ArrayList<String>(List.of("Cpp","Java"));
//		myStr.forEach((n)->System.out.println(n));
//		myStr.forEach(System.out::println);
		
//		AddLambda1 add1 = (a,b)->(a+b);
//		System.out.println(add1.add(2, 3));
		
//		List<String> list = new ArrayList<String>(List.of("Cpp","C#","Java"));
//		list.forEach(s->System.out.println(s));
		
//		AddLambda1 add2 = (a,b)->{
//			return a+b;
//		};
//		System.out.println(add2.add(5, 5));
		
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("thread is running");
			}
		};
		Thread th1 = new Thread(r1,"Thread 1");
		th1.start();
		Runnable r2 = ()->{System.out.println("thread is running 2");};
		Thread th2 = new Thread(r2);
		th2.start();
	}

}
