package practice;

public class Shape {
	public void circumference(double r) {
		double radius = r;
		System.out.println("Circle's Circumference: "+(2*3.14*radius));
	}
	public void perimeter(double a) {
		circumference(a);
	}
	public void perimeter(double a,double b) {
		System.out.println("rectangle's Perimeter: "+(2*(a+b)));
	}
	public void perimeter(double a,double b,double c) {
		System.out.println("triangle's Perimeter: "+(a+b+c));
	}
}
