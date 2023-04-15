package AbstractDemo;

public class Rectangle extends Shape{

	@Override
	void area() {
		System.out.println("Area of Rectangle");
	}
	
	public void perimeter() {
		System.out.println("Perimeter of Rectangle");
	}
	
	public static void main(String [] args) {
		Shape shape = new Rectangle();
		shape.area();
	}

}
