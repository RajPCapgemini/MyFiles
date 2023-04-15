package com.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Employee implements Comparable{
	int eId;
	String name;
	double salary;
	public Employee() {
		
	}
	public Employee(int eId, String name, double salary) {
		super();
		this.eId = eId;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public int compareTo(Object o1) {
		Employee e2=(Employee)o1;
		if(this.eId>e2.eId) return 1;
		else if(this.eId<e2.eId) return -1;
		else return 0;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
class MyPrior implements Comparator{

	public int compare(Integer o1, Integer o2) {
		if(o1>o2) return 1;
		else if(o1<o2) return -1;
		else return 0;
	}

	@Override
	public int compare(Object o1, Object o2) {
		
		if((Integer)o1<(Integer)o2) return 1;
		else if((Integer)o1>(Integer)o2) return -1;
		else return 0;
	}
	
}
public class PriorityQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Queue<Integer> pq = new PriorityQueue<Integer>(new MyPrior());
//		pq.add(6);
//		pq.add(8);
//		pq.add(2);
//		pq.add(3);
//		pq.add(5);
//		pq.add(1);
//		pq.add(7);
//		pq.add(2);
//		System.out.println(pq);
//		pq.remove(5);
//		System.out.println(pq);
		
		Queue<Employee> pq = new PriorityQueue<Employee>();
		pq.add(new Employee(102,"RP",14000));
		pq.add(new Employee(104,"RK",15000));
		pq.add(new Employee(101,"RK",15000));
		pq.add(new Employee(103,"RK",15000));
		System.out.println(pq);
	}

}
