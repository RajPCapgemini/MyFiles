package practice;

public class MyDate {
	private int day;
	private int month;
	private int year;
	private static int count=0;
	public static int showCount() {
		return count;
	}
	public MyDate(int day,int month,int year) {
		this.day=day;
		this.month=month;
		this.year=year;
//		count++;
	}
	public void display() {
		System.out.println(this.day+"/"+this.month+"/"+this.year);
	}
	static void swap(MyDate[] arr) {
		MyDate temp=arr[0];
		arr[0]=arr[1];
		arr[1]=temp;
	}
	
}
