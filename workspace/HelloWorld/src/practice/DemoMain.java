package practice;
import java.util.Arrays;
import java.util.*;

public class DemoMain {

	public static void main(String[] args) {
//		MyDate d1=new MyDate(1,1,1);
//		MyDate d2=new MyDate(2,2,2);
//		d1.display();
//		d2.display();
//		MyDate dateArray[]=new MyDate[2];
//		dateArray[0]=d1;
//		dateArray[1]=d2;
//		MyDate.swap(dateArray);
//		dateArray[0].display();
//		dateArray[1].display();
//		System.out.println(MyDate.showCount());
		
		//ReverseArray
//		Scanner sc=new Scanner(System.in);
//		int [] array1=new int[5];
//		for(int i=0;i<5;i++) {
//			array1[i]=sc.nextInt();
//		}
//		ReverseArray.reverse(array1);
//		for(int i=0;i<5;i++) {
//			System.out.print(array1[i]+" ");
//		}
//		sc.close();
		
		int [] arr= {1,2,3,4,5,6,7,8,9,0};
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
