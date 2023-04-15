package practice;

public class ReverseArray {
	public static void reverse(int [] array) {
		int n=array.length;
		for(int i=0,j=n-1;i<j;i++,j--) {
			int temp=array[i];
			array[i]=array[j];
			array[j]=temp;
		}
	}
}
