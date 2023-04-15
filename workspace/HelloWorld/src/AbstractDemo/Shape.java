package AbstractDemo;

public abstract class Shape {//abstract classes cannot be instantiated because it is incomplete
	abstract void area();
	void display() {
		System.out.println("implemented method");
	}
}
