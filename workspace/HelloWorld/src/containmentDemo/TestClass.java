package containmentDemo;

public class TestClass {

	public static void main(String[] args) {
//		Employee employee=new Employee(100,"RP",new MyDate(1,1,2001),5000);//First contained objects are created then container objects are created
//		System.out.println(employee);
		
//		SalesPerson salesPerson = new SalesPerson(200,"RP2",new MyDate(2,2,2002),6000,10,15000);
//		System.out.println(salesPerson.ComputeSalary());
//		
//		Manager manager = new Manager(400,"RP3",new MyDate(4,4,2002),6000,1000.50,1000);
//		System.out.println(manager.ComputeSalary());
//		
//		Developer developer = new Developer(300,"RP3",new MyDate(3,3,2003),100000,1001,10);
//		System.out.println(developer.ComputeSalary());
		
		//Super Class object reference can hold a sub class object
//		Employee employee1 = new SalesPerson(500,"RP5",new MyDate(5,5,2005),500000,5,500);
//		System.out.println(employee1.computeSalary());
		
//		Employee employee3 = new Manager(700,"RP7",new MyDate(7,7,2007),700000,7,700);
//		System.out.println(employee3.computeSalary());
		
//		downcasting
		Employee e = new Manager(700,"RP7",new MyDate(7,7,2007),700000,7,700);
		if(e instanceof Manager) {
			Manager m=(Manager)e;
			System.out.println(m.getBonus()) ;
		}
	}

}
