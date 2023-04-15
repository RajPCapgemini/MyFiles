package InterfaceDemo;
import java.util.Arrays;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee(102,"Raj",750000);
		Employee e2 = new Employee(101,"Raja",650000);
		Employee e3 = new Employee(104,"Viraj",550000);
		Employee e4 = new Employee(103,"Suraj",450000);
		
		Employee [] employees = {e1,e2,e3,e4};
		Arrays.sort(employees);
		for(int i=0;i<employees.length;i++) {
			System.out.println(employees[i]);
		}
	}

}
