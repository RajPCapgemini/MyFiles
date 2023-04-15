package tester;
import java.util.*;
import com.app.vehicles.*;

public class TestVehicle {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Vehicle 1 Registration No: ");
		int registrationNo=scanner.nextInt();
		System.out.print("Enter Vehicle 1 color: ");
		String color=scanner.next();
		System.out.print("Enter Vehicle 1 price: ");
		double price=scanner.nextDouble();
		Vehicle v1 = new Vehicle(registrationNo,color,price);
		System.out.print("Enter Vehicle 2 Registration No: ");
		registrationNo=scanner.nextInt();
		System.out.print("Enter Vehicle 2 color: ");
		color=scanner.next();
		System.out.print("Enter Vehicle 2 price: ");
		price=scanner.nextDouble();
		Vehicle v2 = new Vehicle(registrationNo,color,price);
		
		System.out.println(v1+"\n"+v2);
		if(v1.equals(v2))
			System.out.println("SAME");
		else
			System.out.println("DIFFERENT");
	}
}
