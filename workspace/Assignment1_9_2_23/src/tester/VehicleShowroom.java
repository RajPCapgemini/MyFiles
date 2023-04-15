package tester;
import java.util.*;

import com.app.vehicles.Vehicle2;

import exceptions.VehicleHandlingException;
import utils.ValidationRules;

public class VehicleShowroom {

	public static void main(String[] args) {
		ArrayList<Vehicle2> vehicles = new ArrayList<Vehicle2>();
		Scanner sc=new Scanner(System.in);
		
		int choice;
		do {
			System.out.println("Enter 1 to add\n2 to display all vehicles\n3 to exit");
			choice=sc.nextInt();
			switch(choice) {
				case 1:{
					System.out.print("Enter registrationNo: ");
					int registrationNo=sc.nextInt();
					System.out.print("Enter vehicle color: ");
					String color= sc.next();
					System.out.print("Enter vehicle price: ");
					double price=sc.nextDouble();
					Vehicle2 v=new Vehicle2(registrationNo,color,price);
					boolean exits=false;
					for(int i=0;i<vehicles.size();i++) {
						if(v.equals(vehicles.get(i))) {
							exits=true;
							try {
								ValidationRules.isDuplicate();
							}catch(VehicleHandlingException e) {
								System.out.println("Error: "+e.getMessage());
							}
							break;
						}
					}
					if(exits==false) { 
						vehicles.add(v);
						System.out.println("Vehicle Added!");
					}
					break;
				}
				case 2:{
					for(int i=0;i<vehicles.size();i++) {
						System.out.println(vehicles.get(i));
					}
					break;
				}
				case 3:{
					choice=0;
					break;
				}
				default:{
					System.out.println("Invalid choice entered");
				}
			}
		}while(choice!=0);
	}

}
