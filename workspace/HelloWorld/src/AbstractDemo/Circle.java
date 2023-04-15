package AbstractDemo;

public class Circle extends Shape{

	public static void main(String[] args) {
		Shape shape = new Circle();
		shape.area();
	}

	@Override
	void area() {
		System.out.println("Area of Circle");
	}

}
