package com.practice.bean;
import java.util.*;

public class HappyNo {

	int digits(int num) {
		int cnt=0;
		while(num>0) {
			cnt++;
			num/=10;
		}
		return cnt;
	}
	int findNewNum(int num) {
		int newNum=0;
		while(num>0) {
			int rem=num%10;
			newNum+=rem*rem;
			num/=10;
		}
		return newNum;
	}
	boolean isHappy(int num) {
		if(digits(num)==1) {
			if(num==1) return true;
			return false;
		}
		num=findNewNum(num);
		return isHappy(num);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		for(int i=0;i<n;i++) {
			int num=scanner.nextInt();
			num*=num;
			HappyNo obj=new HappyNo();
			//Recursion
			if(obj.isHappy(num))
				System.out.println("Happy Number");
			else
				System.out.println("Not Happy Number");
			
			//Loop Implementation
//			while(obj.digits(num)>1) {
//				int newNum=obj.findNewNum(num);
//				num=newNum;
//			}
//			System.out.println(num);
//			if(num==1) {
//				System.out.println("Happy Number");
//			}else {
//				System.out.println("Not Happy Number");
//			}
			scanner.close();
		}
	}

}
