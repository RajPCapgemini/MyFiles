package practice;

public class prac {

	public static void main(String[] args) {
		int [] array1= {1,2,3,4,5,6};
		int [] array2= {11,22,33,44,55,66};
		int [][] array2d = {{1,1,1},{2,2,2},{3,3,3}};
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(array2d[i][j]);
			}
			System.out.println();
		}
		
//		int [] array3=new int[array1.length];
//		for(int i=0;i<array3.length;i++) {
//			array3[i]=array1[i]+array2[i];
//		}
//		for(int i=0;i<array3.length;i++) {
//			System.out.print(array3[i]+" ");
//		}
		int i=10;
		Integer ii=i;
		Integer cc=11;//Autoboxing
		int c=cc;//Unboxing
		System.out.println(i);
		System.out.println(ii);
		System.out.println(c);
		System.out.println(cc);
	}

}
