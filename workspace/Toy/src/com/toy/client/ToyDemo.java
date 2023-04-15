package com.toy.client;

import com.toy.bean.*;

public class ToyDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Toy[] toys = new ElectronicToy[4];
		toys[0]=new ElectronicToy(100,499,"Nerf",4);
		toys[1]=new ElectronicToy(100,459,"Hot Wheels",3);
		toys[2]=new ElectronicToy(100,599,"Cuddles",5);
		toys[3]=new ElectronicToy(100,1499,"Beyblade",2);
		
		for(int i=0;i<4;i++) {
			System.out.println("With Discount: "+toys[i].sellWithDiscount()+" Without Discount: "+toys[i].sellWithoutDiscount());
		}
	}

}
